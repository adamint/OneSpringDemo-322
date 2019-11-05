<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<c:forEach items="${transactions}" var="transaction">
    <form method="post" action="/delete">
        <input type="checkbox" name="delete" onclick="submit()" value="${transaction.key}">
        (<c:out value="${transaction.key}"/>, <c:out value="${transaction.value}"/>)

    </form>
</c:forEach>


<p>You have <c:out value="${transactionNumber}">0</c:out> transactions so far.</p>

<form method="post" action="/add">
    Add task:
    <input type="text" name="add">
    <input type="submit" name="action" value="Add">
</form>

</body>
</html>