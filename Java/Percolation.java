import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
// import java.io.InputStream;

public class Percolation {

    private int N;
    private WeightedQuickUnionUF uf;
    // private WeightedQuickUnionUF ufNew;
    private int sites[];
    private int openSum;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n>0) {
        this.N = n;
        this.sites = new int [N*N+2];
        sites[0] = 1;
        sites[N*N+1] = 1;
        uf = new WeightedQuickUnionUF(N*N+2);
        }
        else    
        throw new IllegalArgumentException();
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N) 
            throw new IllegalArgumentException();
        //if ((row == N) && isFull(row, col))    {uf.union(N*N+1, (row-1)*N+col);}     

        if (sites[(row-1)*N + col]==1) return;
        sites[(row-1)*N + col] = 1;
        openSum ++ ;
        // using weighted quick union UF
        if (row == 1) 
            {uf.union(0, (row-1)*N + col);}
        if ((row!=1) && sites[(row-2)*N+col]==1) 
            {uf.union((row-2)*N + col, (row-1)*N + col);}
        if ((row!=N) && sites[row*N+col]==1 )
            {uf.union(row*N+col, (row-1)*N + col);}
        if (sites[(row-1)*N + col-1]==1 && (col!=1)) 
            {uf.union((row-1)*N+col-1, (row-1)*N+col);}
        if (sites[(row-1)*N + col+1]==1 && (col!=N))
            {uf.union((row-1)*N+col+1, (row-1)*N+col);}
    // System.out.println("top: "+ uf.find((row-1)*N+col));
    // System.out.println("row col: "+ uf.find((row-1)*N+col));
    // System.out.println("bottom: "+ uf.find(N*N+1));
                
        if ((row == N) && (percolates()==false))
            {uf.union(N*N+1, (row-1)*N+col);}

        // if (row == N) uf.union(N*N+1, (row-1)*N + col);
          
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if(row < 1 || row > N || col < 1 || col > N) 
            throw new IllegalArgumentException();
        return (sites[(row-1)*N + col]==1);
    }
    // is the site (row, col) full? * connected to the first row
    public boolean isFull(int row, int col) {
        if(row < 1 || row > N || col < 1 || col > N) 
            throw new IllegalArgumentException();
        // return uf.connected((row-1)*N+col,0); // deprecated
        
        return uf.find(0)==uf.find((row-1)*N+col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSum;
    }

    // does the system percolate?
    public boolean percolates() {
        if ((N == 1)) return uf.find(0)==uf.find(1);            
        return uf.find(0)==uf.find(N*N+1);
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Percolation perc = new Percolation(n);
        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt();
            int col = StdIn.readInt();
            // perc.open(row,col);
            //System.out.println ("is full: "+perc.isFull(row,col));
            perc.open (row,col);
            
            System.out.println ("is open: "+perc.isOpen(row,col));
            
            System.out.println ("percolates: "+perc.percolates());
            System.out.println ("open sites: "+perc.numberOfOpenSites());          
            System.out.println ("is full: "+perc.isFull(row,col));
            // System.out.println("site: "+ perc.sites[(row-1)*n+col]);
            // System.out.println("top: "+ perc.uf.find(0));
            // System.out.println("row col: "+ perc.uf.find((row-1)*n+col));
            // System.out.println("bottom: "+ perc.uf.find(n*n+1));
                       
        }
    }
}
