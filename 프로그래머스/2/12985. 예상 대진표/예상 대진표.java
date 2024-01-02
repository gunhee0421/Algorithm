class Solution
{
    // A: 짝수: a/2 홀수: a/2+1     B: 짝수: b/2 홀수: b/2+1
    // 홀 짝 && A+1=B
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        int A, B;
        A = Math.min(a, b);
        B = Math.max(a, b);

        while (!((A%2==1 && B%2==0) && (A+1==B))) {
            if (A != 1) {
                A=rank(A);
            }
            if (B != 2) {
                B=rank(B);
            }
            answer++;
        }

        return answer;
    }
    public int rank(int a) {
        if (a % 2 == 0) {
            return a / 2;
        }
        else{
            return Math.abs(a/2) + 1;
        }
    }
}