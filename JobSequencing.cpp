// Program to find the maximum profit job sequence from a given array 
// of jobs with deadlines and profits 
#include<bits/stdc++.h>
using namespace std; 

// A structure to represent a job 
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
}; 

class Solution 
{
    public:
    //Function to find the maximum profit and the number of jobs done.
    vector<int> JobScheduling(Job arr[], int n) 
    { 
        vector<pair<int, int>>ap;
        for (int i=0;i<n;i++)
            ap.push_back(make_pair(arr[i].profit, arr[i].dead));
        sort(ap.begin(), ap.end());
        int max = 0;
        for (int i=0;i<n;i++)
            if (max < ap[i].second)
                max = ap[i].second;
        int scd[max+1];
        for (int i=0;i<max+1;i++)
            scd[i] = -1;
        int res = 0, ctr=0;
        for (int i=n-1;i>=0;i--)
        {
            int ded = ap[i].second;
            for (int j=ded;j>=1;j--)
            {
                if(scd[j] == -1)
                {
                    scd[j]++;
                    res += ap[i].first;
                    ctr++;
                    break;
                }
            }
        }
        vector<int>ans;
        ans.push_back(ctr);
        ans.push_back(res);
        return ans;
        // your code here
    } 
};

// { Driver Code Starts.
// Driver program to test methods 
int main() 
{ 
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        Job arr[n];
        
        //adding id, deadline, profit
        for(int i = 0;i<n;i++){
                int x, y, z;
                cin >> x >> y >> z;
                arr[i].id = x;
                arr[i].dead = y;
                arr[i].profit = z;
        }
        Solution ob;
        //function call
        vector<int> ans = ob.JobScheduling(arr, n);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
	return 0; 
}


  // } Driver Code Ends