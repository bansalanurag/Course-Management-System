# Course-Management-System
A CMS corresponding to following problem statement:

Develop a course management system. In this system, entities are course, student and professor. System should be able to handle many courses which can be enrolled by many students (up to max value given for each course) by a single professor. Basic requirements are:
- Students can enroll in a course and later also withdraw from the course.
- Each course must be assigned a faculty.
- Ability to modify any detail of the course.

Student will have the following attribute and functions
- NAME : String UNIQUE
- Degree : String {Btech ,Mtech or Phd}
- Year : integer {1st year, 2, 3, 4, 5}
- Courses enrolled : List of Courses
- Enroll(Course) : function to enroll in a course.
- UnEnroll(Course): function to un-enroll from a course already taken
- ShowStudent : Display all details of the student

Professor will have the following attribute and functions
- NAME : String UNIQUE
- Area_of_expertise :String
- Course_assigned : list of courses
- ShowProf : Display all details of the professor

Course will have the following attribute and functions
- NAME : String UNIQUE
- Max_stud :maximum number of student that can enroll
- Prof: Professor assigned
- Stud_Enrolled : list of student enrolled for this course
- Modify(max_stud, prof) : function to modify the max student limit and the professor of the course
- ShowCourse: Display everything of course

Course Requirement feature: Each course will have certain pre-requisite and constraints which has to be meet by the student who wants to enroll. If these requirement are not satisfied then student cannot enroll for that course and message should be displayed. You have to create a new class for storing all the course requirements. These requirement will be on:
- Degree: course is only for student of certain degree say Mtech.
- Year: course is for which year student say 2nd year.
- Pre-requisite course: course which student should have also enrolled.

Other General functions required:
- Adding a student, course and professor to the system.
- Add proper access modifier to all classes

Input:
Will be given from a text file with a operation in each line. First word will be ID of the operation followed by arguments. Supported operations and arguments are as follows:
ADDS name rollno degree year
ADDP name area_of_expertise
ADDC name max_stud professorname degree year coursename
ENROLL coursename studentname
UNENROLL coursename studentname
MODIFY coursename newmax_stud newprofessorname
SHOWS studname
SHOWP profname
SHOWC coursename

Trivia:
1. There will NOT be any two students, course and professor with the same name.
2. You should add methods in these classes for writing good object oriented code. Try to make a modular code
3. Operation string and other string are case insensitive
4. Handle all corner cases such as enrolling in an enrolled course and un-enrolling a course which was not enrolled etc. It should display proper error message.
