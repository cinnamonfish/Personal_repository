#include <bits/stdc++.h>
// for new user
using namespace std;

double B2006(int x, int a, int y, int b)
{
    return (double)(a * x - b * y) / (a - b);
}

double B2012(double a, double b)
{
    // cout << "a: "<< a<<"b: "<<b<<endl;
    return (double)((100 * b) / a);
}

int P3954(int a, int b, int c){
    return 0.2*a+0.3*b+0.5*c;

}



int main()
{
    // int x, a, y, b;    cin >> x >> a >> y >> b;
    // int a, b;  cin >> a >> b; cout << setiosflags(ios::fixed) << setprecision(3) << B2012(a,b) << "%";
    // "ios::fixed" only limits the output digits of float and double type
    // cout << setiosflags(ios::fixed) << setprecision(2) << B2006(x,a,y,b);
    // int a,b,c; cin >> a>>b>>c; cout << P3954(a,b,c);
    // char s; cin >> s; cout << (char)(s-32); // a -> A
    // double t; int n; cin >> t >> n; cout << setiosflags(ios::fixed) << setprecision(2)<<t/n <<endl<< n*2;
    string s; cin >> s; int len = s.size(); for(int i = len; i>=0; i--) cout << s[i];
}
