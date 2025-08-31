Use Test_LTWeb
GO
CREATE TABLE Users (
    id INT PRIMARY KEY IDENTITY(1,1),
    email VARCHAR(255) NOT NULL,
    userName VARCHAR(255) NOT NULL,
    fullName VARCHAR(255),
    passWord VARCHAR(255),
    phone VARCHAR(50),
);
