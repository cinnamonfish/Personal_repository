import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;




public class PercolationStats {
    private int count;
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;
    private double[] data;
    private double con95 = 1.96;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        if (n == 1) {
            mean = 1;
            stddev = Double.NaN;
            confidenceHi = Double.NaN;
            confidenceLo = Double.NaN;
        }
        else {
            data = new double[trials];
            for(int i=0; i<trials; i++){
                Percolation perco = new Percolation(n);
                count = 0;
                while(!perco.percolates()){
                    int row = StdRandom.uniformInt(n)+1;
                    int col = StdRandom.uniformInt(n)+1;
                    if(!perco.isOpen(row, col)){
                        perco.open(row, col);
                        count ++;
                    }
                }
                // System.out.println(count);        // repeated counting
                double countNew = count;
                data[i] = countNew/(n*n);
            };
        }
        
        stddev = StdStats.stddev(data);
        mean = StdStats.mean(data);
        confidenceLo = mean - con95 * stddev/Math.sqrt(trials);
        confidenceHi = mean + con95 * stddev/Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean(){
        
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        
        return confidenceHi;
    }
    

    public static void main(String[] args){
       
       int n = Integer.parseInt(args[0]);
       int trials = Integer.parseInt(args[1]);
       PercolationStats percoTest = new PercolationStats(n, trials);
       System.out.println ("mean = " + percoTest.mean);
       System.out.println ("stddev = " + percoTest.stddev);
       System.out.println ("95% confidence interval = [" + percoTest.confidenceHi
                            + ", " + percoTest.confidenceLo + "]");
          
    }
}
