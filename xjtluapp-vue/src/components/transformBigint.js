import JSONbig from "json-bigint";

const transformBigint = (data) => {
    try {
        return JSONbig.parse(data)
    } catch (e) {
        return data
    }
}

export {transformBigint}