package com.interview;

/**
 * 2 3   //2个英雄 三件装备
 *
 * 5 6 7  //第一个英雄 拥有一件、两件、三件装备的攻击值
 * 7 8 9
 *
 * 求三个英雄攻击值的最大值
 */
public class T20200824_360_2 {
    public static void main(String[] args) {

    }


}

//#include<iostream>
//#include<vector>
//using namespace std;
//        int main() {
//        int m, n;
//        cin >> m >> n;
//        vector<vector<int>> vec(m+1, vector<int>(n+1));
//        for (int i = 1; i < m+1; i++) {
//        for (int j = 1; j < n+1; j++) {
//        cin >> vec[i][j];
//        }
//        }
//        vector<vector<int>> db(m+1, vector<int>(n+1,0));
//        for (int i = 1; i <= n; i++) {
//        db[1][i] = vec[1][i];
//        }
//        for (int i = 2; i <= m; i++) {
//        for (int j = 1; j <= n; j++) {
//        int max = 0;
//        for (int k = 0; k <= j; k++) {
//        int here = db[i - 1][k] + vec[i][j - k];
//        if (max < here) {
//        max = here;
//        }
//        }
//        db[i][j] = max;
//        }
//        }
//        cout << db[m][n] << endl;
//        return 0;
//        }
