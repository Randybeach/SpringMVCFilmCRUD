<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="tm-nav-section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav class="navbar navbar-expand-md navbar-light">
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#tmMainNav"
							aria-controls="tmMainNav" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>

						<div class="collapse navbar-collapse" id="tmMainNav">
							<ul class="navbar-nav mx-auto tm-navbar-nav">
								<li class="nav-item active">
									<form action="home.do" method="GET">
										<input type="submit" value="Home">
									</form>
								</li>
								<form action="modify.do" method="GET">
									<input type="submit" value="Modify">
								</form>
								</li>
								<li class="nav-item">
									<form action="rick.do" target="_blank">
										<input type="submit" value="Rick">
									</form>
								</li>
								<li class="nav-item">
									<form action="home.do" method="GET">
										<input type="submit" value="Home">
									</form>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" 
codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="640" height="525"><param name="wmode" 
value="transparent" /><param name="movie" 
value="http://video.gprime.net/media/flv/flv.swf?gN=rickroll&gX=640&gY=480&gL=0"></param>
<embed src="http://video.gprime.net/media/flv/flv.swf?gN=rickroll&gX=640&gY=480&gL=0"
wmode="transparent" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" width="640" height="525"></embed></object>


</body>
</html>