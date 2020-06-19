var img_div = ['#img1',	'#img2',	'#img3',	'#img4',	'#img5',	'#img6' ];
var w = 600;
$(function(){
	var w1 = (-1) * (1500 - w) / 2 ;
	$(img_div[0]).css('left', w1);
	var i;
	for(i=0; i<=5; i++){
		$(img_div[i]).css('left', w1-1500);
	}
	
	 i = -1;
	setInterval( function(){
				i++;
				var k=i-1;
				if(k<0)k=5;
				if(i>5){
					i=0;k=5;
				}		
				$(img_div[i]).css('opacity', 1);
				$(img_div[i]).animate({left:w1},100);
				$(img_div[k]).css('opacity', 0);
				$(img_div[k]).animate({left:w1-1500},100);
		} , 2000);
});