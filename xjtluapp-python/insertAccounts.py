# -*- coding: UTF-8 -*-
"""
# @Author:  Zirui Zhou
# @Date:    2022/4/15 18:42:26
# @Contact: zirui.zhou19@student.xjtlu.edu.cn
"""

import hashlib
import mysql.connector
import os

import pandas as pd
import snowflake.client


def readUserInfoList(filename):
    df = pd.read_excel(filename, sheet_name=0)
    df = df[["Surname", "First name", "ID number", "Email address"]]
    return df


def md5Hash(password, salt, iteration=1024):
    saltedPassword = (salt + password).encode()
    for _ in range(iteration):
        saltedPassword = hashlib.md5(saltedPassword).digest()
    return saltedPassword.hex()


def insertToDatabase(df):
    conn = mysql.connector.connect(host="121.5.190.117",
                                   port=3306,
                                   user='student',
                                   password='p5ZPWjd8Yjf8pnzE',
                                   db='student')
    cursor = conn.cursor()
    print("Connect successfully")

    for i in range(df.shape[0]):
        item = df.iloc[[i]]

        user_id = snowflake.client.get_guid()
        user_name = item["First name"].item().lower() + "." + item["Surname"].item().lower()
        salt = os.urandom(32).hex()
        password = md5Hash(user_name, salt)

        real_name = item["First name"].item() + " " + item["Surname"].item()
        real_id = item["ID number"].item()
        email = item["Email address"].item()

        cursor.execute('INSERT INTO student.user (user_id, user_name, password, salt) values (%s, %s, %s, %s)',
                       [user_id, user_name, password, salt])
        cursor.execute('INSERT INTO student.user_info (user_id, real_name, major, semester, real_id, email) values (%s, %s, %s, %s, %s, %s)',
                       [user_id, real_name, "ICS", "Year3", real_id, email])
    print("Insert successfully")

    # Uncomment `commit()` after making sure that the code is OK.
    # conn.commit()
    conn.close()


def main():
    df = readUserInfoList("./CPT202-2122-S2 Project Groups.xlsx")
    insertToDatabase(df)


if __name__ == "__main__":
    main()
