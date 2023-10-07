<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title></title>
<style>

</style>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/commentStyles.css" rel="stylesheet" />
</head>
<body>
	<!-- Comments section-->
	<section class="mb-5 comments-section" >
		<div class="card bg-light">
			<div class="card-body">
				<!-- Comment form-->
				<form class="mb-4">
					<textarea class="form-control" rows="3"
						placeholder="Join the discussion and leave a comment!"></textarea>
				</form>
				<!-- Comment with nested comments-->
				<div class="d-flex mb-4">
					<!-- Parent comment-->
					<div class="flex-shrink-0">
						<img class="rounded-circle"
							src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
					</div>
					<div class="ms-3">
						<div class="fw-bold">이름</div>
						댓글
						<!-- Child comment 1-->
						<div class="d-flex mt-4">
							<div class="flex-shrink-0">
								<img class="rounded-circle"
									src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
							</div>
							<div class="ms-3">
								<div class="fw-bold">이름</div>
								어쩌구
							</div>
						</div>
						<!-- Child comment 2-->
						<div class="d-flex mt-4">
							<div class="flex-shrink-0">
								<img class="rounded-circle"
									src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
							</div>
							<div class="ms-3">
								<div class="fw-bold">이름</div>
								저쩌구
							</div>
						</div>
						
					</div>
				</div>
				<!-- Single comment-->
				<div class="d-flex">
					<div class="flex-shrink-0">
						<img class="rounded-circle"
							src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
					</div>
					<div class="ms-3">
						<div class="fw-bold">이름</div>
						저쩌구
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/commentScripts.js"></script>
</body>
</html>
