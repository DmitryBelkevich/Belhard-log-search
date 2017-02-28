# Belhard-log-search

input params:
=============
rules for RegExp:

- Single filter parameters:
getAllRecordsByDate | getAllRecordsByDateGreater | getAllRecordsByDateLess
data - "12:00:00"

GetRecordsType.getAllRecordsByDateRange
data - "12:00:07-13:00:06"

- Grouping filter parameters:
GetRecordsType.getAllRecordsByUsernameDateRange;
data - "12:00:05-13:00:06 [user1]"
