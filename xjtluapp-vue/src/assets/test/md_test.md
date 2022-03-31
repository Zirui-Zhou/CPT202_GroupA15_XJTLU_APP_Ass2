# Large Efficient Flexible and Trusty (LEFT) Files Sharing

## Introduction

This is one simple project to finish the CAN201 assignment. Just for fun :)

## Testing and Results

It is not very efficient in the final official test. So bad :(

### Testing Environment

| Setting                        | Value                     |
|--------------------------------|---------------------------|
| Virtual System:                | Linux (Core CW1) (64-bit) |
| Virtual System Base Memory:    | 512 MB                    |
| Virtual System Base Processor: | 1 CPU                     |
| Virtual System Base Storage:   | 8.00 GB                   |

### Testing Results

```
Your code: your_code/fileLoader.py your_code/fileScanner.py your_code/fileSocket.py your_code/main.py 
Response from PC_A: file1.bin file2.ppt folders
Response from PC_B: file1.bin file2.ppt folders


**Have linked to PC_A and PC_B. Ready to test.
**** PHASE 1 ****
Start to run your code on PC_A
**** PASS PHASE 1 ****


**** PHASE 2 ****
Move file1.bin (File_1 in the handbook) on PC_A to the share folder.
Start to run your code on PC_B
MD5_1B: PASS


**** PHASE 3 ****
Move file2.ppt (File_2 in the handbook) and folder with 50 files to share folder on PC_B
Kill your code on PC_A
PC_A_IP is killed
Restart PC_A
MD5_2A: PASS
MD5_FA: PASS
MD5_2B: PASS
Result: {'RUN_A': True, 'RUN_B': True, 'MD5_1B': True, 'TC_1B': 0.3729417324066162, 'MD5_2A': True, 'TC_2A+TC_FA': 9.206318378448486, 'MD5_FA': True, 'MD5_2B': 1, 'TC_2B': 9.472455263137817}
```

