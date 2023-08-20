-- Sample Data for myapp_member Table
INSERT INTO myapp_member (member_no, name, email, tel, password, gender, created_date, photo)
VALUES
    (1, 'John Doe', 'john@example.com', '123-456-7890', 'hashed_password', 'M', '2023-08-01', 'profile1.jpg'),
    (2, 'Jane Smith', 'jane@example.com', '987-654-3210', 'hashed_password', 'F', '2023-08-02', 'profile2.jpg');

-- Sample Data for myapp_board Table
INSERT INTO myapp_Board (board_no, title, content, view_count, created_date, animal_no, writer, category)
VALUES
    (1, 'Important Announcement', 'Lorem ipsum dolor sit amet...', 100, '2023-08-03', NULL, 1, 1),
    (2, 'Discussion Topic 1', 'Aenean euismod bibendum...', 75, '2023-08-04', NULL, 2, 2),
    (3, 'Support Request', 'Nullam elementum urna vel...', 50, '2023-08-05', NULL, 1, 3);

-- Sample Data for shelter_animal Table
INSERT INTO myapp_animal (shelter_animal_no, shelter_no, animal_kind_no, age, weight, gender, animal_key, protection_day, specifics, protection)
VALUES
    (1, 1, 1, 2, 5.5, 'M', 123456789, '2023-08-01', 'Healthy and active', 'Y'),
    (2, 2, 2, 3, 7.2, 'F', 987654321, '2023-08-02', 'Friendly and playful', 'N');
