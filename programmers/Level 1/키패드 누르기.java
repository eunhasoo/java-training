public class Solution {

    public int getDistance(int from, int to) {
        // 키패드 0은 값을 11으로 바꿔준다
        from = (from == 0) ? 11 : from;
        to = (to == 0) ? 11 : to;

        int fromX = (from - 1) % 3;
        int fromY = (from - 1) / 3;

        int toX = (to - 1) % 3;
        int toY = (to - 1) / 3;

        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }

    public String solution(int[] numbers, String hand) {
        boolean leftHanded = (hand.equals("left")) ? true : false;

        int leftHand = 10; // *에서 시작
        int rightHand = 12; // #에서 시작

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int key = numbers[i];

            switch (key) {
                // 왼손으로 누르기
                case 1:
                case 4:
                case 7:
                    result.append("L");
                    leftHand = key;
                    break;

                // 오른손으로 누르기
                case 3:
                case 6:
                case 9:
                    result.append("R");
                    rightHand = key;
                    break;

                // 둘 중 가까운 손으로 누르기
                default:
                    int byLeft = getDistance(leftHand, key);
                    int byRight = getDistance(rightHand, key);

                    if (byLeft > byRight) { // 오른손 경로가 더 짧음
                        result.append("R");
                        rightHand = key;
                        break;
                    }

                    if (byLeft < byRight) { // 왼손 경로가 더 짧음
                        result.append("L");
                        leftHand = key;
                        break;
                    }

                    if (leftHanded) { // 경로 길이가 같으면 주로 쓰는 손을 선택
                        leftHand = key;
                        result.append("L");
                    } else {
                        rightHand = key;
                        result.append("R");
                    }
            }
        }

        return result.toString();
    }
}
