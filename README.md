# Online Questionnaire - Object-Oriented Design

### <br>**Overview**<br>
The Online Questionnaire Design project focuses on creating a robust system for building, managing, and evaluating different types of questions commonly found in online questionnaires. By modeling the diverse range of questions and their intricacies, the project serves as a foundation for anyone looking to build or understand online questionnaire platforms like SurveyMonkey, Doodle Poll, and more.

### **Core Components**

**Common Question Properties:**<br>
- Every question holds an essential structure consisting of the text and a method to evaluate answers.

**Likert Class:**<br>
- Handles questions based on the 5-point Likert scale.
- Considers all valid Likert responses as "correct".

**Multiple Choice Class:**<br>
- Manages questions with multiple options but only one correct answer.
- Requires input of the question text, the options, and the correct answer upon creation.

**Multiple Select Class:**<br>
- Manages questions that offer multiple correct answers from a set of options.
- Responses are combinations of option numbers.

**True/False Class:**<br>
- A simple binary choice question type.
- Requires the question text and the correct answer for initialization.

**Question Bank:**<br>
- Stores and organizes different questions.
- Ensures the order of questions is in line with the expected ordering based on question type and then by lexicographical order.

### **Key Takeaways**<br>
- Modularity: The design emphasizes modularity, with distinct classes for each question type, making the system easy to extend and maintain.
- Scalability: The structure allows for potential additions of more question types or modification of existing ones with minimal changes to other parts of the system.
- Ordering Mechanism: The Question Bank's ordering mechanism provides an efficient way to assemble questionnaires, ensuring that they follow a logical and consistent structure.

### **Summary**<br>
The Online Questionnaire project is a holistic solution for those seeking to obtain feedback in a structured and efficient manner. Its wide range of tools ensures that survey creation is a breeze, distribution is widespread, and data analysis is insightful.
