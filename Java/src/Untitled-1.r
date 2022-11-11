md = data.frame(1,1)
length(md)
md
ncol(md)
x = NA
y = x/1
y
library(DescTools)
install.packages("DescTools")
attach(d.pizza)
deliver = aggregate(count, by=list(area,driver), FUN = mean)
v1 = c(1,2,3)
v2 = c(4,5,6)
vbind = cbind(v1,v2)
vbind
as.POSIXlt("Sep-28-2019 07:56:18 AM UTC")
md
md[1,]
md[2,]
p = c("a","b","c")
p[-3]
p[-"a"]
p[1,2,3]
grepl("a|b|c",p)
v1 = c(1:4)
v2 = c(1:2)
v1*v2
v = cbind(v1,v2)
v
b = v
rmat = matrix(c(1,2,3,4),2,2)
upper.tri(rmat)
rmat
rmat[upper.tri(rmat)]
upper.triangular(rmat)
a=c(3,0,TRUE)
b = c(4,0,FALSE)
a|b
