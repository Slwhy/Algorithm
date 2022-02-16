//
// Created by slwhy on 2022/2/15.
//
#include "vector"
#include "queue"
using namespace std;

int mov[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};

void bfs(vector<vector<int>> &image,int sr,int sc,int sourColor,int newColor){
    /**
     * BFS 方法
     */
    queue<vector<int>> q;
    q.push({sr,sc});
    while (!q.empty()){
        image[q.front()[0]][q.front()[1]] = newColor;
        for (int i = 0; i < 4; ++i) {
            int x = q.front()[0]+mov[i][0];
            int y = q.front()[1]+mov[i][1];
            if (x>=0 && y>=0 && x<image.size() && y<image[0].size() && image[x][y]==sourColor){
                q.push({x,y});
            }
        }
        q.pop();
    }
}

void dfs(vector<vector<int>> &image,int sr,int sc,int sourColor,int newColor){
    if(sr>=0 && sc>=0 && sr<image.size() && sc<image[0].size() && image[sr][sc]==sourColor){
        image[sr][sc]=newColor;
        for (int i = 0; i < 4; ++i) {
            dfs(image,sr+mov[i][0],sc+mov[i][1],sourColor,newColor);
        }
    }
}

void floodFillCore(vector<vector<int>> &image, int sr, int sc, int sourColor, int newColor, int row, int column,vector<vector<int>>arrivedMap) {
    /*
     * dfs 最初没有考虑到新旧颜色一致的话会无限递归，
     * 考虑后直接采用vector 记录访问过的位置
     * 其实可以直接特色处理这种情况，一致的话不会改变地图颜色
     */
    if (sr>=0 && sc>=0 && sr < row && sc < column && image[sr][sc] == sourColor && arrivedMap[sr][sc]==0) {
        image[sr][sc] = newColor;
        arrivedMap[sr][sc]=1;
        for (int i = 0; i < 4; ++i) {
            floodFillCore(image,sr+mov[i][0],sc+mov[i][1],sourColor,newColor,row,column,arrivedMap);
        }
    }
}

vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int newColor) {
    int sourColor = image[sr][sc];
//    int row = image.size();
//    int column = image[0].size();
//    vector<vector<int>> arrivedMap(image.size(), vector<int>(image[0].size(),0));
//    floodFillCore(image,sr,sc,sourColor,newColor,row,column,arrivedMap);
    if (image[sr][sc]==newColor) return image;
    bfs(image,sr,sc,image[sr][sc],newColor);
    return image;
}
int main(){
//vector<vector<int>> image = {{0,0,0},{0,1,1}};
    vector<vector<int>> image = {{1,1,1},{1,1,0},{1,0,1}};
    floodFill(image,1,1,2);
}