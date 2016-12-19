$(window).load(function() {

});

/*$(window).resize(function() {

});*/

jQuery(function($) {
	var mobile;

	var SPMaskBehavior = function (val) {
	  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
	},
	spOptions = {
	  onKeyPress: function(val, e, field, options) {
	      field.mask(SPMaskBehavior.apply({}, arguments), options);
	    }
	};

	var App = {
		inicial:{
			ajustaAltura:function(){

				if (mobile == false){
					var heightWindow = $(window).height();
					if (heightWindow >= 830){
						$(".autoHeight").css("height", heightWindow);
					}else{
						$(".autoHeight").css("height", 830);
					}
				}else{
					$(".autoHeight").addClass('padding-mobile');
				}
			},

			iframeVideo : function(){
				/* FUNÇÃO ADICIONA A CLASSE FLEX-VIDEO EM TODOS OS IFRAMES QUE CONTÉM NA PARTE DE TEXTO DO SITE */
				  $('.entry-text iframe').each(function() {
				      $(this).wrap('<div class="flex-video"></div>');
				  });
			},

			imgResponsive : function(){
				/* FUNÇÃO ADICIONA A CLASSE img-responsive EM TODOS AS IMAGENS QUE CONTÉM NA PARTE DE TEXTO DO SITE */
				  $('.entry-text img').each(function() {
				    $(this).addClass("img-responsive");
				  });
			},

			ajustaAlturaHome:function(){
				var heightWindow = $(window).height();
				$("#home").css("height", heightWindow);
				console.log(heightWindow);
			},

			iniciaCarousel: function(){
				$('.owl-videos').owlCarousel({
				    margin:10,
				    responsive:{
				        0:{
				            items:2
				        },
				        600:{
				            items:3
				        },
				        1000:{
				            items:4
				        }
				    }
				});
			},
			ligaLlightbox: function(){

				$( ".link-video" ).each(function() {
				 	var videoID = $(this).attr('id');
				 	$("#"+videoID).iLightBox();
				});
			}
		},
		verificaMobile: {
			verifica: function(){
				var isMobile = false; //initiate as false
				// device detection
				if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
				    || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) isMobile = true;
				//console.log("versao mobile = "+ isMobile);
				mobile = isMobile;

				if (mobile){
					$("body").addClass('mobile');
				}
			}
		},


		sidebar:{
			inicia: function(){
				var controller = new $.slidebars();
			}
		},
		apresentacao:{
			carousel: function(){
				$('.owl-apresentacao').owlCarousel({
				    margin:10,
				    responsive:{
				        0:{
				            items:2
				        },
				        600:{
				            items:2
				        },
				        1000:{
				            items:3
				        }
				    }
				});
			}
		},
		cadastro:{
			iniciaSlider: function(){
				$('.owl-slider').owlCarousel({
				    margin:10,
				    items:1
				});
			},
			controleID:function(){
				$(".inputOutroID").click(function(){
				   if ($(this).is(":checked")) {
			            $("#controle-form").removeClass("campo-oculto");
			        } else {
			            $("#controle-form").addClass("campo-oculto");
			        }
				});

				$(".inputOutroLogin").click(function(){
				   if ($(this).is(":checked")) {
			            $("#controle-login-form").removeClass("campo-oculto");
			        } else {
			            $("#controle-login-form").addClass("campo-oculto");
			        }
				});
			},
			ajudaCursor:function(){
				$('.ajuda').popover();
			},
			cloneEmails:function(){
				
				$(".bt-mini").click(function(){
					var clone = $(".cloneEmail .tpl-email").clone();
					console.log(clone);
				  	$(clone).appendTo("#mais-emails");
				  	App.cadastro.removeEmail();
				});
			},
			removeEmail:function(){
				$(".bt-mini-remove").click(function(){
				  	$(this).parent().parent().remove();
				});
			},

			cloneTelefone:function(){
				
				$(".bt-mini-tel").click(function(){
					var clone = $(".cloneTel .tpl-telefone").clone();
					console.log(clone);
				  	$(clone).appendTo("#mais-telefones");
				  	App.cadastro.removeTelefone();
				});
			},
			removeTelefone:function(){
				$(".bt-remove-tel").click(function(){
				  	$(this).parent().parent().parent().remove();
				});
			},

			mostraEmails:function(){
				$(".inputControleEmail").click(function(){
					console.log("cliquei aqui");
				   if ($(this).is(":checked")) {
			            $(".caixa-emails").removeClass("campo-oculto");
			        } else {
			            $(".caixa-emails").addClass("campo-oculto");
			        }
				});
			},

			mascaras:function(){
				  $('.date').mask('00/00/0000');
				  $('.time').mask('00:00:00');
				  $('.date_time').mask('00/00/0000 00:00:00');
				  $('.cep').mask('00000-000');
				  $('.phone').mask('0000-0000');
				  $('.phone_with_ddd').mask('(00) 0000-0000');
				  $('.phone_us').mask('(000) 000-0000');
				  $('.sp_celphones').mask(SPMaskBehavior, spOptions);
				  $('.mixed').mask('AAA 000-S0S');
				  $('.cpf').mask('000.000.000-00', {reverse: true});
				  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
				  $('.money').mask('000.000.000.000.000,00', {reverse: true});
				  $('.money2').mask("#.##0,00", {reverse: true});
				  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
				    translation: {
				      'Z': {
				        pattern: /[0-9]/, optional: true
				      }
				    }
				  });
				  $('.ip_address').mask('099.099.099.099');
				  $('.percent').mask('##0,00%', {reverse: true});
				  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
				  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
				  $('.fallback').mask("00r00r0000", {
				      translation: {
				        'r': {
				          pattern: /[\/]/,
				          fallback: '/'
				        },
				        placeholder: "__/__/____"
				      }
				    });
				  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});

			}

		},
		menuPrincipal:{
			clone:function(){
				var menu = $(".user-avatar");
				var notificacoes = $(".dockbar-user-notifications");

				$("#menu-user").append(menu);
				$("#notifications").append(notificacoes);

				$(".user-notifications-count").after('<div class="icon-alert icon"></div>');
			}
		},
		controleVideo:{
			inicia:function(){
				
				$("#videoMonitorado").on("finish", function(){
					$("#videoMonitorado").parent().fadeOut();
				    $("#conteudo-oculto").fadeIn();
				    App.inicial.iniciaCarousel();
				});


				$("#btn-continue-lendo").click(function(){
				    $("html,body").animate({
				        scrollTop: $("#intro5").offset().top
				    },"500");
				});

				$("#btn-continue-video").click(function(){
				    $("html,body").animate({
				        scrollTop: $("#intro10").offset().top
				    },"500");
				});

			}
		},
		share:{
			carouselImagens:function(){

				var owlShare = jQuery('.owl-imagens-share');
			    owlShare.owlCarousel({  
			        margin:10,
				    dots: false,
				    responsive:{
				        0:{
				            items:1
				        },
				        600:{
				            items:2
				        },
				        800:{
				            items:3
				        },
				        1000:{
				            items:4
				        }
				    }
			    });

				$('.bt-next').click(function() {
				      owlShare.trigger('next.owl.carousel');
				});

				$('.bt-prev').click(function() {
				      owlShare.trigger('prev.owl.carousel');
				});

			},
			btCopiar:function(){

				

				if($("#bt-copiar").length == 0) {
				  
				}else{
					document.getElementById("bt-copiar").addEventListener("click", function() {
					    copyToClipboard(document.getElementById("copyTarget"));
					});
				}

				function copyToClipboard(elem) {
					  // create hidden text element, if it doesn't already exist
				    var targetId = "_hiddenCopyText_";
				    var isInput = elem.tagName === "INPUT" || elem.tagName === "TEXTAREA";
				    var origSelectionStart, origSelectionEnd;
				    if (isInput) {
				        // can just use the original source element for the selection and copy
				        target = elem;
				        origSelectionStart = elem.selectionStart;
				        origSelectionEnd = elem.selectionEnd;
				    } else {
				        // must use a temporary form element for the selection and copy
				        target = document.getElementById(targetId);
				        if (!target) {
				            var target = document.createElement("textarea");
				            target.style.position = "absolute";
				            target.style.left = "-9999px";
				            target.style.top = "0";
				            target.id = targetId;
				            document.body.appendChild(target);
				        }
				        target.textContent = elem.textContent;
				    }
				    // select the content
				    var currentFocus = document.activeElement;
				    target.focus();
				    target.setSelectionRange(0, target.value.length);
				    
				    // copy the selection
				    var succeed;
				    try {
				    	  succeed = document.execCommand("copy");
				    } catch(e) {
				        succeed = false;
				    }
				    // restore original focus
				    if (currentFocus && typeof currentFocus.focus === "function") {
				        currentFocus.focus();
				    }
				    
				    if (isInput) {
				        // restore prior selection
				        elem.setSelectionRange(origSelectionStart, origSelectionEnd);
				    } else {
				        // clear temporary content
				        target.textContent = "";
				    }
				    return succeed;
				}

			}
		}

	};
	App.verificaMobile.verifica();
	App.inicial.ajustaAltura();
	App.inicial.ajustaAlturaHome();
	
	App.inicial.ligaLlightbox();

	App.inicial.iframeVideo();
	App.inicial.imgResponsive();

	// Liga o funcionamento do menu so sidebar
	App.sidebar.inicia();

	// Liga o carousel da pagina apresentação
	App.apresentacao.carousel();

	// Liga o carousel da pagina de cadastro
	App.cadastro.iniciaSlider();
	App.cadastro.controleID();

	// Clona o menu do lafirey e transfere pro local correto
	App.menuPrincipal.clone();

	// Faz o controle de quando é finalizado o video que está na pagina inicial
	App.controleVideo.inicia();

	// Inicia o carousel de imagens da pagina de share
	App.share.carouselImagens();

	// Habilita a função de copiar o texto na pagina de share
	App.share.btCopiar();

	App.cadastro.ajudaCursor();

	App.cadastro.cloneEmails();

	App.cadastro.cloneTelefone();

	App.cadastro.mascaras();

	App.cadastro.mostraEmails();
});