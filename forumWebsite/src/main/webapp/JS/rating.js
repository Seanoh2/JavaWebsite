$(document).ready(function () {
    $(".ratingButton").click(function () {
        var post = $(this).data('post');
        var user = $(this).data('user');
        var rating = $(this).data('value');
        var ratingView = 0;

        if ($(this).is(":checked")) {
            ratingView = rating;
        } else {
            if (rating === 1) {
                ratingView = -1;
            } else {
                ratingView = 1;
            }
            rating = 0;
        }

        var ratingDiv = '#rating' + post.toString();
        console.log(ratingDiv.toString());
        $(ratingDiv.toString()).find(':input').not(this).prop('checked', false);

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