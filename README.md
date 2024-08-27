# 📅ScheduleManager_extension 소개

 
## 📌ERD
![Untitled (5)](https://github.com/user-attachments/assets/13702d2a-6626-4b99-b5ef-f79143d8d6ff)


   
### TABLE Schedule
| 이름 | 타입 | 제약조건 | 설명 |
| :-- | :-- | :-- | :-- |
| schedule_id | integer | PK, AUTO\_INCREMENT | 일정의 고유번호, PK |
| schedule_title | VARCHAR(20) | NOT NULL | 스케쥴 제목 |
| schedule_data | VARCHAR(100) | NOT NULL | 스케쥴 내용 |
| create_datetime | VARCHAR(20) | NOT NULL | 수정일자, DATETIME 형식 |
| edit_datetime | VARCHAR(20) | NOT NULL | 작성일자, DATETIME 형식 |

> ### 상세 설명
> #### TABLE Schedule   
> schedule_id : 스케쥴을 추가하거나 삭제할 때, ID를 기준으로 참조.   
> &emsp;&emsp;그만큼 **핵심 Column이기도 하며 중복이 되어선 안되기에, PK로 지정**.
>    
> schedule_title : 스케쥴의 제목으로 NULL이 되어선 안되기에, **NOT NULL형태로 지정**
>    
> schedule_data : 스케쥴의 내용으로 NULL이 되어선 안되기에 **NOT NULL형태로 지정**.
>
> edittime : 수정 시각으로 연월일시분초 다 저장해야 하기에 DATETIME 형식으로 저장, **NOT NULL 형태로 지정**.   
>   
> createtime: 작성 시각으로 연월일시분초 다 저장해야 하기에 DATETIME 형식으로 저장, **NOT NULL 형태로 지정**.
<br/>
   
## 📌API명세서
 | **기능** | **Method** | **URL** | **request** | **response** | **state code** |
 | --- | --- | --- | --- | --- | --- |
 | 일정 작성 | POST | /api/schedules | 요청body | 등록 정보 | 200작성 성공  <br>416제목 길이 오류 |
 | 선택한 일정 조회 | GET | /api/schedules/{scheduleId} | 요청param | 단건 일정 정보 | 200조회 성공  <br>404조회 실패 |
 | 선택한 일정 수정 | PUT | /api/schedules/{scheduleId} | 요청body | 수정 정보 | 200수정 성공 <br>404조회 실패 |

> ### 상세 설명 - 일정
> #### 🛠️일정 작성
>> #### Request
>> ##### Syntax
>> ```
>> { 
>>    "shcedule_title" : "today Todo"
>>    "schedule_data": "programming",
>> }
>> ```
>> ##### Request Elements
>> | **Parameter** | **Type** | **Required** | **Description** |
>> | --- | --- | --- | --- |
>> | shcedule_title | String | 필수 | 스케쥴 제목 |
>> | schedule_data | String | 필수 | 스케쥴 내용 |
>>     
>> ##### Response
>> ###### Syntax
>> ```
>> {
>>     "schedule_id": 12,
>>     "shcedule_title": "title",
>>     "schedule_data": "data",
>>     "editTime": "2024-08-26 00:07:28",
>>     "createTime": "2024-08-26 00:07:28"
>> }
>> ```
>>    
>> ###### Element   
>> | **Parameter** | **Type** | **Description** |
>> | --- | --- | --- |
>> | schedule_id | Integer | 스케쥴 고유 번호 |
>> | shcedule_title | String | 스케쥴 제목 |
>> | schedule_data | String | 스케쥴 내용 |
>> | editTime | String | 스케쥴 수정 시간 |
>> | createTime | String | 스케쥴 생성 시간 |
>>
>> ###### State Code   
>> | **Code** | **Description** | **Detail** |
>> | --- | --- | --- |
>> | 200 | 작성 성공 | 해당 정보를 토대로 스케쥴 생성 성공 |
>> | 416 | 작성 실패 | 제목이나 내용의 길이가 범위를 벗어남 |
>>    
>> <br/>
>    
> #### 🛠️선택한 일정 조회
>> #### Request
>> #### Syntax
>> ```
>> /api/schedules/{scheduleId}
>> ``` 
>> ##### Path Elements
>> | **Parameter** | **Type** | **Required** | **Description** |
>> | --- | --- | --- | --- |
>> | scheduleId | Integer | 필수 | 조회하고자 하는 스케쥴 고유 번호 |
>> 
>>     
>> ##### Response
>> ###### Syntax
>> ```
>> {
>>     "schedule_id": 13,
>>     "shcedule_title": "title",
>>     "schedule_data": "data",
>>     "editTime": "2024-08-26 00:09:28",
>>     "createTime": "2024-08-26 00:09:28"
>> }
>> ```
>>    
>> ###### Element   
>> | **Parameter** | **Type** | **Description** |
>> | --- | --- | --- |
>> | schedule_id | Integer | 스케쥴 고유 번호 |
>> | shcedule_title | String | 스케쥴 제목 |
>> | schedule_data | String | 스케쥴 내용 |
>> | editTime | String | 스케쥴 수정 시간 |
>> | createTime | String | 스케쥴 생성 시간 |
>> 
>> ###### State Code   
>> | **Code** | **Description** | **Detail** |
>> | --- | --- | --- |
>> | 200 | 조회 성공 | 스케쥴 조회 성공 |
>> | 404 | 조회 실패 | 해당 Id를 가진 스케쥴이 존재하지 않음 |
>>
>> <br/>
> #### 🛠️선택한 일정 수정
>> #### Request   
>> ##### Param Elements
>> ##### Syntax
>> ```
>> /api/schedules/{sceduleId}
>> ```
>> | **Parameter** | **Type** | **Required** | **Description** |
>> | --- | --- | --- | --- |
>> | scheduleId | Integer | 필수 | 조회하고자 하는 스케쥴 고유 번호 |
>> <br/>
>>    
>> ```
>> { 
>>    "shcedule_title" : "today Todo"
>>    "schedule_data": "programming",
>> }
>> ```
>> ##### Request Elements
>> | **Parameter** | **Type** | **Required** | **Description** |
>> | --- | --- | --- | --- |
>> | shcedule_title | String | 필수 | 스케쥴 제목 |
>> | schedule_data | String | 필수 | 스케쥴 내용 |
>> <br/>
>>     
>> ##### Response
>> ###### Syntax
>> ```
>> {
>>     "schedule_id": 14,
>>     "shcedule_title": "title",
>>     "schedule_data": "data",
>>     "editTime": "2024-08-27 00:19:28",
>>     "createTime": "2024-08-27 00:19:28"
>> }
>> ```
>>    
>> ###### Element   
>> | **Parameter** | **Type** | **Description** |
>> | --- | --- | --- |
>> | schedule_id | Integer | 스케쥴 고유 번호 |
>> | shcedule_title | String | 스케쥴 제목 |
>> | schedule_data | String | 스케쥴 내용 |
>> | editTime | String | 스케쥴 수정 시간 |
>> | createTime | String | 스케쥴 생성 시간 |
>> 
>> ###### State Code   
>> | **Code** | **Description** | **Detail** |
>> | --- | --- | --- |
>> | 200 | 조회 성공 | 스케쥴 조회 성공 |
>> | 404 | 조회 실패 | 해당 번호의 스케쥴이 존재하지 않음 |
>> <br/>
>>    
