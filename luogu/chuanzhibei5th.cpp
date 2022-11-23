#include<bits/stdc++.h>

using namespace std;

int compare(const void *a, const void *b)
{
    int *pa = (int*)a;
    int *pb = (int*)b;
    return (*pa )- (*pb);  // don't know how to write
}

int T292113(int n, int nums[], int w) {
    qsort(nums, n, sizeof(int), compare);
    int buy = -1;
    
    for(int i = n-1; i>=0; i--) {
        if(w>=nums[i]) {buy = nums[i];break;}          // if "buy" then {buy <- nums[i]} else {buy = -1}
    }
    int count = 0;
    for(int i = 0; i<n; i++) {
        if(buy>=nums[i]) {
            buy -= nums[i];
            count ++;
        }
    }
    count = max(count,1);
    if(buy ==-1) count = 0;
    return count;
}

// 嗷呜嗷呜
int T293037() {
    return 0;
}

int main() {
    int n;    cin >> n;
    int nums[n];    for(int i = 0; i<n; i++) cin >> nums[i];
    int w; cin >> w;             // money
    cout << T292113(n,nums,w);
}

/*
input: 
1
3
2
output : supposed to be 0
*/