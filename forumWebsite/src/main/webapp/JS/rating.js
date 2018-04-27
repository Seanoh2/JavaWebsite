$(document).ready(function () {
    $(".ratingButton").click(function () {
        var post = $(this).data('post');
        var user = $(this).data('user');
        var rating = $(this).val();
        
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
                console.log(updateScore);
                
                var ratingScore = document.getElementById(updateScore);
                var oldScore = ratingScore.innerHTML;
                var newScore = +oldScore + +rating;
                
                ratingScore.innerHTML = newScore;
            }
        });
    });
});