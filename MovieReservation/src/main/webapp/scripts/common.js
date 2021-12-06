document.addEventListener('scroll', function() {
	swp=1;
	flagprofilesidebar();
});	

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1} 
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none"; 
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block"; 
  dots[slideIndex-1].className += " active";
}

function flagprofilesidebar(){
	if(swp==1){
		document.getElementById('profilesidebardiv').style.width = '0px';
		swp=0;
	}else{				
		document.getElementById('profilesidebardiv').style.width = '450px';
		swp=1;
	}
}
function asd(){
	alert("asdasdas");	
}
function showyoutube(n){
	if(n==1){
		if(document.getElementById('spidermanyoutube').style.display=='block'){
			document.getElementById('spidermanyoutube').style.display = 'none';
		}else{
			document.getElementById('spidermanyoutube').style.display = 'block';
		}
	}else if(n==2){
		if(document.getElementById('matrixyoutube').style.display=='block'){
			document.getElementById('matrixyoutube').style.display = 'none';
		}else{
			document.getElementById('matrixyoutube').style.display = 'block';
		}
	}else if(n==3){
		if(document.getElementById('copshopyoutube').style.display=='block'){
			document.getElementById('copshopyoutube').style.display = 'none';
		}else{
			document.getElementById('copshopyoutube').style.display = 'block';
		}
	}
}
function selectmovietitle(n){
	for(i=1; i<=5; i++){
		document.getElementById("movietitlediv" + i).style.backgroundColor = '#f2f0e5';
		document.getElementById("movietitlelabel" + i).style.color = 'black';
		document.getElementById("movieage" + i).src = document.getElementById("movieage" + i).src.replace("z", "w")
	}
	document.getElementById("movietitlediv" + n).style.backgroundColor = '#333333';
	document.getElementById("movietitlelabel" + n).style.color = 'white';
	document.getElementById("movieage" + n).src = document.getElementById("movieage" + n).src.replace("w", "z")	
	document.getElementById("tdregiondiv").style.display = 'block';
}

function selectmovieregion(n){
	for(i=1; i<=9; i++){
		document.getElementById("movieregiondiv" + i).style.backgroundColor = '#f2f0e5';
		document.getElementById("movieregionlabel" + i).style.color = 'black';
	}
	document.getElementById("movieregiondiv" + n).style.backgroundColor = '#333333';
	document.getElementById("movieregionlabel" + n).style.color = 'white';
	document.getElementById("tddatediv").style.display = 'block';
}

function selectmoviedate(n){
	for(i=1; i<=10; i++){
		document.getElementById("moviedatediv" + i).style.backgroundColor = '#f2f0e5';
		document.getElementById("moviedatelabel" + i).style.color = 'black';
		document.getElementById("moviedaylabel" + i).style.color = 'black';
		if(document.getElementById("moviedaylabel" + i).innerText=="토"){
			document.getElementById("moviedatelabel" + i).style.color = 'blue';
			document.getElementById("moviedaylabel" + i).style.color = 'blue';
		}else if(document.getElementById("moviedaylabel" + i).innerText=="일"){
			document.getElementById("moviedatelabel" + i).style.color = 'red';
			document.getElementById("moviedaylabel" + i).style.color = 'red';
		}
	}
	document.getElementById("moviedatediv" + n).style.backgroundColor = '#333333';
	document.getElementById("moviedatelabel" + n).style.color = 'white';
	document.getElementById("moviedaylabel" + n).style.color = 'white';
	if(confirm("선택하신 날짜로 예약을 하시겠습니까?")){
		alert("로그인이 필요한 서비스입니다.");
		location.href = "ticketingseat.html";
	}
}
function caldate(){
	let today = new Date();
	var week = ['일', '월', '화', '수', '목', '금', '토'];
	document.getElementById("yearlabel").innerText = today.getFullYear();
	document.getElementById("monthlabel").innerText = today.getMonth()+1;
	
	for(i=1; i<=10; i++){
		document.getElementById("moviedaylabel" + i).innerText = week[today.getDay()];
		document.getElementById("moviedatelabel" + i).innerText = today.getDate();
		if(today.getDay()==0){
			document.getElementById("moviedaylabel" + i).style.color = "red";
			document.getElementById("moviedatelabel" + i).style.color = "red";
		}
		if(today.getDay()==6){
			document.getElementById("moviedaylabel" + i).style.color = "blue";
			document.getElementById("moviedatelabel" + i).style.color = "blue";
		}
		today.setDate(today.getDate()+1);
	}
}
function num_of_seat(){
	document.getElementById("price").innerText = document.getElementById("combnum").value * 14000;
	reset_seat();
}
function is_fit_num(){
	var count = 0;
	for(i=1;i<=10;i++) {
		if (i == 10) {
			if (document.getElementById("a"+i) == null)
				break;
			if (document.getElementById("a"+i).checked)
				count++;
		}
		else if(document.getElementById("a0"+i) == null) {
			continue;
		}
		else if (document.getElementById("a0"+i).checked)
				count++;
	}
	for(i=1;i<=10;i++) {
		if (i == 10) {
			if (document.getElementById("b"+i) == null)
				break;
			if (document.getElementById("b"+i).checked)
				count++;
		}
		else if(document.getElementById("b0"+i) == null) {
			continue;
		}
		else if (document.getElementById("b0"+i).checked)
				count++;
	}
	for(i=1;i<=10;i++) {
		if (i == 10) {
			if (document.getElementById("c"+i) == null)
				break;
			if (document.getElementById("c"+i).checked)
				count++;
		}
		else if(document.getElementById("c0"+i) == null) {
			continue;
		}
		else if (document.getElementById("c0"+i).checked)
				count++;
	}
	for(i=1;i<=10;i++) {
		if (i == 10) {
			if (document.getElementById("d"+i) == null)
				break;
			if (document.getElementById("d"+i).checked)
				count++;
		}
		else if(document.getElementById("d0"+i) == null) {
			continue;
		}
		else if (document.getElementById("d0"+i).checked)
				count++;
	}
	for(i=1;i<=10;i++) {
		if (i == 10) {
			if (document.getElementById("e"+i) == null)
				break;
			if (document.getElementById("e"+i).checked)
				count++;
		}
		else if(document.getElementById("e0"+i) == null) {
			continue;
		}
		else if (document.getElementById("e0"+i).checked)
				count++;
	}
	if(document.getElementById("combnum").value!=count){
		alert("선택한 인원수와 좌석수가 일치하지 않습니다.");
		
	}
}