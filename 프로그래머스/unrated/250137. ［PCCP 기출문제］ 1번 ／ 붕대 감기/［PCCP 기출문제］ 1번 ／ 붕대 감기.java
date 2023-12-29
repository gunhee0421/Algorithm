class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer;
        int time = 0, hp = health, count = 0, atackCount=0;
        while (attacks[attacks.length-1][0] > time) {
            time++;
            if (time == attacks[atackCount][0]) {
                hp -= attacks[atackCount][1];
                if (hp < 1) {
                    return -1;
                }
                count = 0;
                atackCount++;
            }
            else {
                count++;
                if (hp < health) {
                    hp += bandage[1];
                    if (count == bandage[0]) {
                        hp += bandage[2];
                        count = 0;
                    }
                    if (hp > health) {
                        hp = health;
                    }
                }
                if (count == bandage[0]) {
                    count = 0;
                }
            }
        }
        answer = hp;
        return answer;
    }
}