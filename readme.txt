Frame work tested with OpenJDK11 + gradle 5.2.1

Group14

Benjamin Biber    (01530133)   benjamin.biber@student.tugraz.at
Alexander Wachter (01532068)   a.wachter@student.tugraz.at
Bernhard Salzmann ()            ....


Description of the Program:
---------------------------
- So far the program is capable to detect lexical- and syntactical errors as well as typchecking errors.


-------------------
Remarks for task 1:
-------------------
General remarks:
----------------
- Implemented Task 1, with still some issues at OperatorDotTest, AccessTest, UndeclaredTest.

Changes  made:
--------------
- completed the lexer rules in the grammer file. (Jova.g4) As well as the definition of missing parser rules.
- completed the warmeup Task in LexicalAndSyntaxAnalyzer.java.
- edited Typechecker to raise found errors of TypeCheckerVisitor
- created TypCheckerVisitor to check for Typechecking errors.
- edited Test cases in TypeCheckerPublicTest

Known limitations:
------------------
- According to the private TC our programm is still not capable of handling:
      - "." accesses (like members or chain method invocation) properly.
      - handling the access attributes correct (this is most probably somehow connected to the limitation mentioned above).
      - handling undeclared identifiers correctly.

Implemented BONUS tasks:
------------------------
- ...


-------------------
Remarks for task 2:
-------------------
General remarks:
----------------
Implemented Task 2 with obviously still some issues within the code generation, which we were not able to find. Probably
that issues are side effects of the known limitations from task 1.

Changes  made:
--------------
- Implemented code generation task.
- added CodeGeneratorVisitor which actually generates the jasmin code
- implemented various jasmin instructions as Java classes.
- implemented private testsuite

Known limitations:
------------------
- As already stated in the general remarks section, we do not pass all private testcases to 100% on GitLab but
this is probably due to some side effects of the not fixed issues of task 1 (probably not only, but to some degree this
assumption should be valid).

Implemented BONUS tasks:
------------------------
...

Percentage of participation:
----------------------------
Benjamin Biber       50%
Alexander Wachter    50%
Bernhard Salzmann     0%


-------------------
Remarks for task 3:
-------------------
General remarks:
----------------
Implemented Task 3 according to the assignment sheet. CodeOpt is able to reduce the instructions of all arithmetic
programs (no conditional jumps...)  to a single LDC or to none, depending on print statements.

Changes  made:
--------------
- Implemented calculate Liveness And Next Next Use.
- Implemented Constant Propagation.
- Implemented Constant Folding.
- Implemented Swap Removal.
- Implemented Dead Code Removal.
- Implemented remove Return.
- implemented private testsuite

Known limitations:
------------------
Optimization is only made to work for "simple Programs" (see assignments sheets).
Will not optimize programms with division 0 or modulo 0;




Implemented BONUS tasks:
------------------------
...

Percentage of participation:
----------------------------
Benjamin Biber       50%
Alexander Wachter    50%
Bernhard Salzmann     0%

