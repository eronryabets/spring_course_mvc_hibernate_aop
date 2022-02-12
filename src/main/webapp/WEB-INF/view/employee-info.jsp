<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Employee info</h2>
<br>

<from:form action="saveEmployee" modelAttribute="employee">

    Name<form:input path="name"/>
    <br><br>
    Surname<form:input path="surname"/>
    <br><br>
    Department<form:input path="department"/>
    <br><br>
    Salary<form:input path="salary"/>
    <br><br>

    <input type="submit" value="OK">


</from:form>


</body>

</html>