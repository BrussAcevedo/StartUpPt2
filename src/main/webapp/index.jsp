<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<%@include file="assets/html/importHead.html"%>
<link rel="stylesheet" href="assets/css/styles.css">
<link rel = "stylesheet" href ="assets/css/stylesNavbar.css">
</head>
<body>
	<%@include file="assets/html/navbar.html"%>


	<div class="margen-general container">


		<header class="">
			<h1 class="pt-4">Bienvenidos al Portal del equipo</h1>
			<div class="pb-2 pt-2">
				<hr>
			</div>
		</header>

		<section class="row ">
					<h2 class ="pb-4 text-center">Destacados:</h2>
			<div class="galeria col-12 container pb-5">
				
				<div id="carouselExampleFade"
					class="carousel slide carousel-fade w-100" data-bs-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="assets/img/imagen1.jpg" class="d-block w-100"
								alt="Imagen1 No disponible">
						</div>
						<div class="carousel-item">
							<img src="assets/img/imagen2.jpg" class="d-block w-100"
								alt="Imagen2 No disponible">
						</div>
						<div class="carousel-item">
							<img src="assets/img/imagen3.jpg" class="d-block w-100"
								alt="Imagen3 No disponible">
						</div>

						<div class="carousel-item">
							<img src="assets/img/imagen4.jpg" class="d-block w-100"
								alt="Imagen4 No disponible">
						</div>

						<div class="carousel-item">
							<img src="assets/img/imagen5.jpg" class="d-block w-100"
								alt="Imagen5 No disponible">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleFade" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleFade" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>

			</div>
			
			<hr>
			<section class="novedades">
				<div class="pt-3">
					<h2 id="list-item-1" class="text-center">Novedades</h2>
				</div>

				<div class="row align-items-center">

					<div class="novedades1 col-6 d-flex justify-content-center">
						<img class="w-75 " alt=""
							src="https://images.ctfassets.net/8zlbnewncp6f/7acNKbo0aJceJfFdip6v6Z/e61433f37a27509558f340972037211d/Suzuki_New_Spresso_Galgo_Chile.png?w=600&fm=webp&q=90">
					</div>
					<div class="col-6 align-items-center">
						<h4 class ="py-2">Lorem ipsum dolor sit amet</h4>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam,
							eaque ipsa quae ab illo inventore veritatis et quasi architecto
							beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
							quia voluptas sit aspernatur aut odit aut fugit, sed quia
							consequuntur magni dolores eos qui ratione voluptatem sequi
							nesciunt.</p>


					</div>

					<div class="col-6 align-items-center">
						<h4 class ="py-2">Lorem ipsum dolor sit amet</h4>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam,
							eaque ipsa quae ab illo inventore veritatis et quasi architecto
							beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
							quia voluptas sit aspernatur aut odit aut fugit, sed quia
							consequuntur magni dolores eos qui ratione voluptatem sequi
							nesciunt.</p>
					</div>

					<div class="novedades1 col-6 d-flex justify-content-center">
						<img class="w-75 " alt=""
							src="https://maquinarias.pe/wp-content/uploads/2023/01/%E9%87%91-03.jpg">
					</div>

					<div class="col-12 align-items-center">
						<h4 class ="py-2">Lorem ipsum dolor sit amet</h4>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam,
							eaque ipsa quae ab illo inventore veritatis et quasi architecto
							beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
							quia voluptas sit aspernatur aut odit aut fugit, sed quia
							consequuntur magni dolores eos qui ratione voluptatem sequi
							nesciunt.</p>
					</div>

					<div class="novedades1 col-12 d-flex justify-content-center  py-5">
						<img class="w-50 " alt=""
							src="https://cdn.buttercms.com/W3j7VuQDSrOF8XMyjkY9">
					</div>


				</div>
				
			</section>
			
			<div class="news col-12"></div>

			<div class="cartas"></div>

		</section>
	</div>


	<%@include file="assets/html/footer.html"%>
	<%@include file="assets/html/importFooter.html"%>

</body>
</html>