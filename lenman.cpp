#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll Bigmod(ll a, ll b, ll m)
{
    ll res = 1; // for ll value not use the pow function so use below lines
    for (ll i = 1; i <= b; i++)
    {
        res = (res * a) % m;
    }
    return res;
}

bool lehmannAglorithm(ll p, int test)
{
    if (p == 2 || p == 3)
        return 1;
    if (p == 1 || p % 2 == 0)
        return 0;

    for (int i = 0; i < test; i++)
    {
        ll a = 2 + (rand() % (p - 2)); // a between the value 2 and (p-1)
        ll L = Bigmod(a, (p - 1) / 2, p);
        if (L != 1 && L != -1 && L != (p - 1))
            return 0;
    }
    return 1;
}

int main()
{
    ll num; // 180181
    cout << "Enter a number: ";
    cin >> num;

    int test;
    cout << "Enter number of Test: ";
    cin >> test;

    int prime = lehmannAglorithm(num, test);
    if (prime)
        cout << "May be Prime\n";
    else
        cout << "Definitely not prime\n";
    return 0;
}

/*

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class LehmannAlgorithm {

    static BigInteger bigmod(BigInteger a, BigInteger b, BigInteger m) {
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(b) <= 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(a).mod(m);
        }
        return res;
    }

    static boolean lehmannAlgorithm(BigInteger p, int test) {
        if (p.equals(BigInteger.valueOf(2)) || p.equals(BigInteger.valueOf(3)))
            return true;
        if (p.equals(BigInteger.ONE) || p.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
            return false;

        Random rand = new Random();
        for (int i = 0; i < test; i++) {
            BigInteger a = BigInteger.valueOf(2).add(new BigInteger(p.subtract(BigInteger.valueOf(3)).bitLength(), rand)); // a between the value 2 and (p-1)
            BigInteger L = bigmod(a, p.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)), p);
            if (!L.equals(BigInteger.ONE) && !L.equals(p.subtract(BigInteger.ONE)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        BigInteger num = scanner.nextBigInteger();

        System.out.print("Enter number of Tests: ");
        int test = scanner.nextInt();

        boolean prime = lehmannAlgorithm(num, test);
        if (prime)
            System.out.println("May be Prime");
        else
            System.out.println("Definitely not prime");
        scanner.close();
    }
}


*/