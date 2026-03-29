<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Task Manager</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Icons -->
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>

body{
background: linear-gradient(135deg,#667eea,#764ba2);
min-height:100vh;
}

.card{
border-radius:15px;
}

.table-hover tbody tr:hover{
background:#f2f2f2;
transition:0.3s;
}

</style>

</head>

<body>

<div class="container mt-5">

<div class="card shadow-lg">

<div class="card-header text-white d-flex justify-content-between align-items-center"
style="background: linear-gradient(45deg,#ff6a00,#ee0979);">

<h4 class="mb-0">
<i class="bi bi-list-check"></i> Student Task Manager
</h4>

<a class="btn btn-light btn-sm fw-bold"
href="${pageContext.request.contextPath}/add">

<i class="bi bi-plus-circle"></i> Add Task

</a>

</div>

<div class="card-body">

<!-- Filters -->

<div class="mb-3">

<a class="btn btn-outline-primary btn-sm"
href="${pageContext.request.contextPath}/">
<i class="bi bi-grid"></i> All
</a>

<a class="btn btn-outline-warning btn-sm"
href="${pageContext.request.contextPath}/pending">
<i class="bi bi-hourglass-split"></i> Pending
</a>

<a class="btn btn-outline-success btn-sm"
href="${pageContext.request.contextPath}/completed">
<i class="bi bi-check-circle"></i> Completed
</a>

</div>

<table class="table table-hover table-bordered text-center align-middle">

<thead class="table-dark">

<tr>
<th>ID</th>
<th>Title</th>
<th>Description</th>
<th>Status</th>
<th>Edit</th>
<th>Delete</th>
</tr>

</thead>

<tbody>

<c:forEach var="task" items="${tasks}">

<tr>

<td>${task.id}</td>

<td class="fw-semibold">${task.title}</td>

<td>${task.description}</td>

<td>

<c:choose>

<c:when test="${task.status == 'Completed'}">
<span class="badge bg-success px-3 py-2">
<i class="bi bi-check-circle"></i> Completed
</span>
</c:when>

<c:otherwise>
<span class="badge bg-warning text-dark px-3 py-2">
<i class="bi bi-hourglass"></i> Pending
</span>
</c:otherwise>

</c:choose>

</td>

<td>

<a class="btn btn-info btn-sm"
href="${pageContext.request.contextPath}/edit?id=${task.id}">

<i class="bi bi-pencil-square"></i>

</a>

</td>

<td>

<a class="btn btn-danger btn-sm"
href="${pageContext.request.contextPath}/delete?id=${task.id}"
onclick="return confirm('Delete this task?')">

<i class="bi bi-trash"></i>

</a>

</td>

</tr>

</c:forEach>

</tbody>

</table>

</div>

</div>

</div>

</body>
</html>