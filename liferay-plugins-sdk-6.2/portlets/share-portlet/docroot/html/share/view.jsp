<%@ include file="init.jsp" %>

<div id="sb-site">

<header id="top-internas">
	<div class="container">
		<h1 class="title-header">Compartilhar Oportunidade</h1>
	</div>
</header>

<div id="content">
	<div class="container">
		<div class="page-share">
			
			<h2>Endere�o da sua p�gina</h2>
			<div class="caixa-end-user">
				<div id="copyTarget" class="endereco-user">www.lapidarios.com.vc/<%=lojaId %></div>
			</div>

			<hr>

			<div class="caixa-compartilhe">
				<h2>Compartilhe nas redes</h2>

				<ul id="redes" class="reset">
					<li>
						<div id="fb-root"></div>
						<script>(function(d, s, id) {
						  var js, fjs = d.getElementsByTagName(s)[0];
						  if (d.getElementById(id)) return;
						  js = d.createElement(s); js.id = id;
						  js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.8";
						  fjs.parentNode.insertBefore(js, fjs);
						}(document, 'script', 'facebook-jssdk'));</script>					
						
						<div class="fb-share-button" data-href="<%=homeURL %>" data-layout="button" data-size="large" data-mobile-iframe="true"><a class="btn-facebook bt-compartilhe" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=<%=homeURL %>"><i class="icon icon-facebook"></i> Facebook</a></div>
					</li>
					<li>
    					<a class="btn-linkedin bt-compartilhe" href="http://www.linkedin.com/shareArticle?mini=true&url=<%=homeURL %>" title="linkedin Share" target="_blank"><i class="icon icon-linkedin"></i> Linkedin</a>
  					</li>					
					<li>
						<a href="https://twitter.com/share" class="btn-twitter bt-compartilhe" data-lang="pt_BR" data-url="<%=homeURL %>" target="_blank"><i class="icon icon-twitter"></i> Twitter</a>
						<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
					</li>
				</ul>
				
			</div>
			
		</div> <!-- .fim .page-share -->
	</div>
</div>

</div> <!-- .fim div sb-site -->
