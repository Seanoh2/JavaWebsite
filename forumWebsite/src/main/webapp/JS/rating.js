$(document).ready(function () {
    $(":input").click(function () {
        var post = $(this).data('post');
        var user = $(this).data('user');
        var rating = $(this).data('value');
        var ratingView = 0;

        var ratingDiv = '#rating' + post.toString();
        $(ratingDiv.toString()).find(':input').not(this).prop('checked', false);

        if ($(this).is(":checked")) {
            ratingView = rating;
        } else {
            if (rating === 1) {
                if ($(ratingDiv.toString()).find(':input').not(this).is('checked')) {
                    ratingView = -2;
                } else {
                    ratingView = -1;
                }
            } else if (rating === -1) {
                if ($(ratingDiv.toString()).find(':input').not(this).is('checked')) {
                    ratingView = 2;
                } else {
                    ratingView = 1;
                }
            } else {
                ratingView = 0;
            }
            rating = 0;
        }

        $.ajax({
            url: "RatingServlet",
            type: "POST",
            data: {userID: user,
                postID: post,
                rating: rating
            },
            success: function () {

                var updateScore = "ratingScore";
                updateScore += post;

                var ratingScore = document.getElementById(updateScore);
                var oldScore = ratingScore.innerHTML;
                var newScore = +oldScore + +ratingView;

                ratingScore.innerHTML = newScore;
            }
        });
    });
});