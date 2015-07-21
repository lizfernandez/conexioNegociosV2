$('a.smoothScroll').smoothScroll({
	offset : -80,
	scrollTarget : $(this).val()
});
// Waypoints
$('.post_article').waypoint(function(direction) {
	if (direction === 'down') {
		var wayID = $(this).attr('id');
	} else {
		var previous = $(this).prev();
		var wayID = $(previous).attr('id');
	}
	$('.current').removeClass('current');
	$('#main_nav a[href=#' + wayID + ']').addClass('current');
}, {
	offset : '40%'
});
/// StickNav
var stickyNavTop = $('.nav').offset().top;

var stickyNav = function(){
var scrollTop = $(window).scrollTop();

if (scrollTop && stickyNavTop) {
$('.nav').addClass('isStuck');
} else {
$('.nav').removeClass('isStuck');
}
};
stickyNav();
$(window).scroll(function() {
stickyNav();
});