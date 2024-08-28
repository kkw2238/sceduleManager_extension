CREATE TABLE schedule(
     schedule_id INTEGER PRIMARY KEY AUTO_INCREMENT,
     schedule_title VARCHAR(20) NOT NULL,
     schedule_data VARCHAR(100) NOT NULL,
     manager_name VARCHAR(20) NOT NULL,
     create_DateTime VARCHAR(20) NOT NULL,
     edit_DateTime VARCHAR(20) NOT NULL
);