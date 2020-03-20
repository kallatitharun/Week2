/*
On the first row, we write a “0”. Now in every subsequent row, we look at the previous row and replace each occurrence of “0” with “01”,
 and each occurrence of “1” with “10”.
Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed)
Examples:
Input: N = 1, K = 1
Output: 0
Input: N = 2, K = 1
Output: 0
Input: N = 2, K = 2
Output: 1
Input: N = 4, K = 5
Output: 1

 */
public class problem09
{
    static int kIndexedSymbol(int n,int k)
    {
        int[][] array=new int[n][(int) Math.pow(2,n)];
        array[0][0]=0;
        int columnIter=0,j;
        for(int i=0;i<n-1;i++)
        {
            columnIter=0;
            for(j=0;j<Math.pow(2,i);j++)
            {
                if(array[i][j]==0)
                {
                    array[i+1][columnIter++]=0;
                    array[i+1][columnIter++]=1;
                }
                else
                {
                    array[i+1][columnIter++]=1;
                    array[i+1][columnIter++]=0;
                }
            }
        }
        return array[n-1][k-1];
    }
    static void testCases()
    {
        int[] n={1,2,2,4};
        int[] k={1,1,2,5};
        for(int i=0;i<n.length;i++)
            System.out.println(kIndexedSymbol(n[i],k[i]));
    }
    public static void main(String[] args)
    {
        testCases();
    }
}
