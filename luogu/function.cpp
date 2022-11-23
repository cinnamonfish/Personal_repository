#include <bits/stdc++.h>
using namespace std;

struct point
{
    double x;
    double y;
};

double distance(point p1, point p2)
{
    return sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
}

bool isPrime(int num)
{
    if (num > 2 && num % 2 == 0)
        return false;
    if (num == 1)
        return false;
    if (num == 2)
        return true;
    for (int i = 3; i <= sqrt(num); i += 2)
    {
        if(num % i == 0)
            return false;
    }
    return true;
    /*
    if(n<=1) return false;
    if(n==2||n==3) return true;
    if(n%6!=1&&n%6!=5) return false;
    for(int i=5;i*i<=n;i+=6) if(n%i==0||n%(i+2)==0) return false;
    return true;*/
}



bool isPalindrome(string s) {
    string copy = s;
    reverse(s.begin(),s.end());
    if(s==copy) return true;
    return false;
}

int a[1030][1030];

void cheat(int x, int r, int c)
{
    if (x == 2)
    {
        a[r][c] = 0;
        return;
    }
    for (int i = r; i < r + x / 2; i++)
    {
        for (int j = c; j < c + x / 2; j++)
        {
            a[i][j] = 0;
        }
    } // clear the up-left square
    cheat(x / 2, r + x / 2, c);
    cheat(x / 2, r, c + x / 2);
    cheat(x / 2, r + x / 2, c + x / 2);
}

bool odd(int n) {
    int weishu = floor(log10(n));
    if(weishu>1 && weishu%2!=0) return false;
    if((int)(n/pow(10,weishu))%2==0) return false;
    return true;
}

struct student {
    string name;
    int id;
    int yuwen;
    int shuxue;
    int yingyu;
    int sum;
};

bool compareStudent(student a, student b) {
    if(a.sum==b.sum) return a.id<b.id;
    return a.sum>b.sum;
}


#include <bits/stdc++.h>
using namespace std;

struct student {
    string name;
    int id;
    int yuwen;
    int shuxue;
    int yingyu;
    int sum;
};

bool compareStudent(student a, student b) {
    if(a.sum==b.sum) return a.id<b.id;
    return a.sum>b.sum;
}

bool duishou(student a, student b) {
    if(a.yuwen>=b.yuwen-5 && a.yuwen<=b.yuwen+5 && 
        a.shuxue>=b.shuxue-5 && a.shuxue<=b.shuxue+5 &&
        a.yingyu>=b.yingyu-5 && a.yingyu<=b.yingyu+5 &&
        a.sum>=b.sum-10 && a.sum<=b.sum+10) return true;
        return false;
}


    /*   Qiguxiangdang De Duishou - Problem *
    int n; cin >> n;
    vector<student> students;
    for(int i = 0; i < n; i++) {
            student current;
            current.id = i;
            cin >> current.name >> current.yuwen >> current.shuxue >> current.yingyu;
            current.sum = current.yuwen + current.shuxue + current.yingyu;
            students.push_back(current);
        }
    for(int i = 0; i < n; i++) {
        for(int j = i+1; j<n; j++) {
            if(duishou(students[i],students[j])) cout << students[i].name <<" "<< students[j].name << endl;
        }
    }
    */



int main()
{
    int n; cin >> n;
    vector<student> students;

    for(int i = 0; i < n; i++) {
        student current;
        current.id = i;
        cin >> current.name >> current.yuwen >> current.shuxue >> current.yingyu;
        current.sum = current.yuwen + current.shuxue + current.yingyu;
        students.push_back(current);
    }
    for(student i:students) i.sum = i.yuwen + i.shuxue + i.yingyu;
    //stable_sort(students.begin(),students.end(),compareStudent);    // how to write "compare" in c++ sort
    cout << students[0].name;
    /*  Palindromic Prime Numbers
    int a, b;
    cin >> a >> b;
    
    for(int i = (a%2==0?a-1:a); i<=b; i+=2) {
        if(i!=2&&i%2==0) i++;
        if(odd(i)&&isPrime(i)&&isPalindrome(to_string(i))) cout << i << endl;
    }
    */

    //for(int i = 1; i<=100; i++) cout << i<<" "<<log10(i) << endl;

    
    int n;
    cin >> n;
    int x = pow(2, n);
    for (int i = 0; i < x; i++)
    {
        for (int j = 0; j < x; j++)
            a[i][j] = 1;
    }
    cheat(x, 0, 0);
    for (int i = 0; i < x; i++)
    {
        for (int j = 0; j < x-1; j++)
            cout << a[i][j] << " ";
        cout << endl;
    }


    /*point p1,p2,p3;
    cin >> p1.x >> p1.y >> p2.x >> p2.y >> p3.x >> p3.y;
    cout << setiosflags(ios::fixed) << setprecision(2) << distance(p1,p2)+distance(p1,p3)+distance(p2,p3);
   int n; cin >> n; for(int i = 1; i<=n; i++) if(isPrime(i)) cout << i << " ";


    */
}
