package class1_problem;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview[] mReview = {
                new MovieReview("인셉션", "인생은 무한 루프"),
                new MovieReview("어바웃 타임", "그냥저냥재밌음")
        };
        for (MovieReview movieReview : mReview) {
            System.out.println("영화 제목 :" + movieReview.title + ", 리뷰:" + movieReview.review);
        }

    }
}
