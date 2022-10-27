package onboarding;

import java.util.List;


/**
 * 책을 임의로 펼친다.
 * 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *
 * feature
 * 1. check whether page is valid
 * 2. create maximum value of the page
 * 3. compare value
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValidPage(pobi) || !isValidPage(crong))
            return -1;

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        return determineWinner(pobiMax, crongMax);
    }
    private static int determineWinner(int pobiMax, int crongMax){
        if(pobiMax>crongMax)
            return 1;

        if(pobiMax==crongMax)
            return 0;

        return 2;
    }
    private static int getMax(List<Integer> pages) {
        return Math.max(Math.max(sumDigitOfPage(pages.get(0)), sumDigitOfPage(pages.get(1))),
                            Math.max(multiplyDigitOfPage(pages.get(0)),multiplyDigitOfPage(pages.get(1))));

    }

    private static boolean isValidPage(List<Integer> pages){
        //invalid case : if page is not continue
        return pages.get(1) - pages.get(0) == 1;
    }

    private static int sumDigitOfPage(Integer page){
        int result = page%10;
        page/=10;

        while(page!=0){
           result+=page%10;
           page/=10;
        }

        return result;
    }

    private static int multiplyDigitOfPage(Integer page){
        int result = page%10;
        page/=10;

        while(page!=0){
           result*=page%10;
           page/=10;
        }

        return result;
    }
}