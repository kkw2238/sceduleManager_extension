# 📅ScheduleManager_extension 소개

 
## 📌ERD
![Untitled (6)](https://github.com/user-attachments/assets/d2417559-78cf-45d5-95f6-2f6e589dfbd1)


   
### TABLE Schedule
| 이름 | 타입 | 제약조건 | 설명 |
| :-- | :-- | :-- | :-- |
| schedule_id | integer | PK, AUTO\_INCREMENT | 일정의 고유번호, PK |
| schedule_title | VARCHAR(20) | NOT NULL | 스케쥴 제목 |
| schedule_data | VARCHAR(100) | NOT NULL | 스케쥴 내용 |
| manager_name | VARCHAR(20) | NOT NULL | 담당자 이름 |
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
> manager_name : 담당자 이름으로 NULL이 되어선 안되기에, **NOT NULL 형태로 지정**.
>    
> createtime: 작성 시각으로 연월일시분초 다 저장해야 하기에 DATETIME 형식으로 저장, **NOT NULL 형태로 지정**.
<br/>

### TABLE Comment
| 이름 | 타입 | 제약조건 | 설명 |
| :-- | :-- | :-- | :-- |
| comment_id | integer | PK, AUTO\_INCREMENT | 일정의 고유번호, PK |
| schedule_id | VARCHAR(20) | FK, NOT NULL | 댓글 ID |
| comment_data | VARCHAR(100) | NOT NULL | 댓글 내용 |
| username | VARCHAR(20) | NOT NULL | 작성자 이름 |
| create_datetime | VARCHAR(20) | NOT NULL | 수정일자, DATETIME 형식 |
| edit_datetime | VARCHAR(20) | NOT NULL | 작성일자, DATETIME 형식 |

> ### 상세 설명
> #### TABLE Comment   
> comment_id : 스케쥴을 추가하거나 삭제할 때, ID를 기준으로 참조.   
> &emsp;&emsp;그만큼 **핵심 Column이기도 하며 중복이 되어선 안되기에, PK로 지정**.
>    
> schedule_id : 댓글이 달려있는 스케쥴 고유번호 외래키, **NOT NULL형태로 지정**
>    
> comment_data : 댓글의 내용으로 NULL이 되어선 안되기에 **NOT NULL형태로 지정**.
>
> edit_datetime : 수정 시각으로 연월일시분초 다 저장해야 하기에 DATETIME 형식으로 저장, **NOT NULL 형태로 지정**.   
>
> username : 작성자 이름으로 NULL이 되어선 안되기에, **NOT NULL 형태로 지정**.
>    
> create_datetime: 작성 시각으로 연월일시분초 다 저장해야 하기에 DATETIME 형식으로 저장, **NOT NULL 형태로 지정**.
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
>>    "managerName" : "kim kun woo"
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
>>     "managerName" : "kim kun woo",
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
>>     "managerName" : "kim kun woo",
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
>>     "managerName" : "kim kun woo",
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

## 📌API명세서 
| **기능** | **Method** | **URL** | **request** | **response** | **state code** |
| --- | --- | --- | --- | --- | --- |
| 댓글 작성 | POST | /api/comments | 요청body | 등록 정보 | 200작성 성공 |
| 선택한 댓글 조회 | GET | /api/comments/{commentId} | 요청param | 단건 댓글  정보 | 200조회 성공   404조회 실패 |
| 모든 댓글 조회 | GET | /api/comments | X | 모든 댓글 정보 | 200조회 성공 |
| 선택한 댓글 수정 | PUT | /api/comments/{commentId} | 요청body | 수정 정보 | 200수정 성공   404조회 실패 |
| 선택한 댓글 삭제 | DELETE | /api/comments/{commentId} | 요청param | 단일 삭제 | 200삭제 성공   404조회 실패 |

> ### 상세 설명 - 댓글
> 
> #### 🛠️댓글 작성
> 
> > #### Request
> > 
> > ##### Syntax
> > 
> > ```
> > {
> >    "schedule_id" : 1
> >    "comment_data" : "Ok"
> >    "userName" : "kim kun woo",
> > }
> > ```
> > 
> > ##### Request Elements
> > 
> > | **Parameter** | **Type** | **Required** | **Description** |
> > | --- | --- | --- | --- |
> > | schedule\_id | Integer | 필수 | 스케쥴 제목 |
> > | comment\_data | String | 필수 | 스케쥴 제목 |
> > | userName | String | 필수 | 작성자 내용 |
> > 
> > ##### Response
> > 
> > ###### Syntax
> > 
> > ```
> > {
> >     "commentId": 5,
> >     "scheduleId": 2,
> >     "commentData": "OK",
> >     "userName": "kun woo",
> >     "createDateTime": "2024-08-29 02:08:17",
> >     "editDateTime": "2024-08-29 02:08:17"
> > }
> > ```
> > 
> > ###### Element
> > 
> > | **Parameter** | **Type** | **Description** |
> > | --- | --- | --- |
> > | commentId | Integer | 댓글 고유 번호 |
> > | scheduleId | Integer | 관련된 스케쥴 Id |
> > | commentData | String | 댓글 내용 |
> > | userName | String | 작성자 |
> > | editTime | String | 댓글 수정 시간 |
> > | createTime | String | 댓글 생성 시간 |
> > 
> > ###### State Code
> > 
> > | **Code** | **Description** | **Detail** |
> > | --- | --- | --- |
> > | 200 | 작성 성공 | 해당 정보를 토대로 댓글 생성 성공 |
> 
> #### 🛠️선택한 댓글 조회
> 
> > #### Request
> > 
> > #### Syntax
> > 
> > ```
> > /api/comments/{commentId}
> > ```
> > 
> > ##### Path Elements
> > 
> > | **Parameter** | **Type** | **Required** | **Description** |
> > | --- | --- | --- | --- |
> > | commentId | Integer | 필수 | 조회하고자 하는 댓글 고유 번호 |
> > 
> > ##### Response
> > 
> > ###### Syntax
> > 
> > ```
> > {
> >     "commentId": 5,
> >     "scheduleId": 2,
> >     "commentData": "OK",
> >     "userName": "kun woo",
> >     "createDateTime": "2024-08-29 02:08:17",
> >     "editDateTime": "2024-08-29 02:08:17"
> > }
> > ```
> > 
> > ###### Element
> > 
> > | **Parameter** | **Type** | **Description** |
> > | --- | --- | --- |
> > | commentId | Integer | 댓글 고유 번호 |
> > | scheduleId | Integer | 관련된 스케쥴 Id |
> > | commentData | String | 댓글 내용 |
> > | userName | String | 작성자 |
> > | editTime | String | 댓글 수정 시간 |
> > | createTime | String | 댓글 생성 시간 |
> > 
> > ###### State Code
> > 
> > | **Code** | **Description** | **Detail** |
> > | --- | --- | --- |
> > | 200 | 조회 성공 | 스케쥴 조회 성공 |
> > | 404 | 조회 실패 | 해당 Id를 가진 스케쥴이 존재하지 않음 |
> 
> #### 🛠️선택한 댓글 수정
> 
> > #### Request
> > 
> > ##### Param Elements
> > 
> > ##### Syntax
> > 
> > ```
> > /api/comments/{commentId}
> > ```
> > 
> > | **Parameter** | **Type** | **Required** | **Description** |
> > | --- | --- | --- | --- |
> > | commentId | Integer | 필수 | 조회하고자 하는 댓글 고유 번호 |
> > |   |   |   |   |
> > 
> > ```
> > { 
> >    "commentData" : "Hi"
> > }
> > ```
> > 
> > ##### Request Elements
> > 
> > | **Parameter** | **Type** | **Required** | **Description** |
> > | --- | --- | --- | --- |
> > | commentData | String | 필수 | 수정하고자 하는 댓글 내용 |
> > 
> > ##### Response
> > 
> > ###### Syntax
> > 
> > ```
> > {
> >     "commentId": 5,
> >     "scheduleId": 2,
> >     "commentData": "Hi",
> >     "userName": "kun woo",
> >     "createDateTime": "2024-08-29 02:08:17",
> >     "editDateTime": "2024-08-29 02:08:17"
> > }
> > ```
> > 
> > ###### Element
> > 
> > | **Parameter** | **Type** | **Description** |
> > | --- | --- | --- |
> > | commentId | Integer | 댓글 고유 번호 |
> > | scheduleId | Integer | 관련된 스케쥴 Id |
> > | commentData | String | 댓글 내용 |
> > | userName | String | 작성자 |
> > | editTime | String | 댓글 수정 시간 |
> > | createTime | String | 댓글 생성 시간 |
> > 
> > ###### State Code
> > 
> > | **Code** | **Description** | **Detail** |
> > | --- | --- | --- |
> > | 200 | 조회 성공 | 스케쥴 조회 성공 |
> > | 404 | 조회 실패 | 해당 번호의 스케쥴이 존재하지 않음 |
> >
> #### 🛠️선택한 댓글 삭제
> >
> > #### Request
> > 
> > ##### Param Elements
> > 
> > ##### Syntax
> > 
> > ```
> > /api/comments/{commentId}
> > ```
> > 
> > | **Parameter** | **Type** | **Required** | **Description** |
> > | --- | --- | --- | --- |
> > | commentId | Integer | 필수 | 삭제하고자 하는 댓글 고유 번호 |
> > 
> > ```
> > { 
> >    2
> > }
> > ```
> > 
> > ##### Request Elements
> > | **Parameter** | **Type** | **Required** | **Description** |
> > | --- | --- | --- | --- |
> > |  | Integer | 필수 | 삭제된 댓글 Id |
