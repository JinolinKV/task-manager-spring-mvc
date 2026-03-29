<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

<title>Task</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Icons -->
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>

body{
background: linear-gradient(135deg,#36d1dc,#5b86e5);
min-height:100vh;
}

.card{
border-radius:15px;
}

</style>

</head>

<body>

<div class="container mt-5">

<div class="card shadow-lg col-md-6 mx-auto">

<div class="card-header text-white"
style="background: linear-gradient(45deg,#ff512f,#dd2476);">

<h4 class="mb-0">

<c:if test="${task.id == 0}">
<i class="bi bi-plus-circle"></i> Add Task
</c:if>

<c:if test="${task.id != 0}">
<i class="bi bi-pencil-square"></i> Edit Task
</c:if>

</h4>

</div>

<div class="card-body">

<form action="${pageContext.request.contextPath}/save" method="post">

<input type="hidden" name="id" value="${task.id}">

<div class="mb-3">

<label class="form-label fw-semibold">
<i class="bi bi-card-text"></i> Title
</label>

<input class="form-control"
type="text"
name="title"
value="${task.title}"
placeholder="Enter task title"
required>

</div>

<div class="mb-3">

<label class="form-label fw-semibold">
<i class="bi bi-journal-text"></i> Description
</label>

<input class="form-control"
type="text"
name="description"
value="${task.description}"
placeholder="Enter task description"
required>

</div>

<div class="mb-3">

<label class="form-label fw-semibold">
<i class="bi bi-flag"></i> Status
</label>

<select class="form-select" name="status">

<option value="Pending"
<c:if test="${task.status == 'Pending'}">selected</c:if>>
 Pending
</option>

<option value="Completed"
<c:if test="${task.status == 'Completed'}">selected</c:if>>
 Completed
</option>

</select>

</div>

<div class="d-flex gap-2">

<button class="btn btn-success">
<i class="bi bi-save"></i> Save Task
</button>

<a class="btn btn-secondary"
href="${pageContext.request.contextPath}/">

<i class="bi bi-arrow-left"></i> Back

</a>

</div>

</form>

</div>

</div>

</div>

</body>

</html>