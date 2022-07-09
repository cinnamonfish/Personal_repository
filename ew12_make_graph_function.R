library(dplyr)
library(igraph)
library(data.table)
make_graph = function(edgeDir,
                      ew12)
{
  edge = fread(edgeDir)
  #gg = graph_from_edgelist(egg[,1:2]|>as.matrix(), directed = FALSE)
  
  edgelist = cbind(node1 = edge$"#node1",node2 = edge$node2)
  pos = which(edgelist[,1] %in% as.matrix(ew12[,1])&
                edgelist[,2] %in% as.matrix(ew12[,1]) )
  edge_new = edgelist[pos,]
  graph = igraph::graph_from_edgelist(edge_new, directed = FALSE)
  igraph::graph_from_edgelist(edgelist, directed = FALSE)
  
  #posGene = names(igraph::V(graph))
  #names(ew12)
  posp = which(ew12$HGNC%in%names(V(graph)))
  p = ew12$ew12.pval[posp]
  names(p) = ew12$HGNC[posp]
  V(graph)[order(names(V(graph)))]$size = -log10(p[order(names(p))])*10
  prop = round(p,digits=4)
  prop[which(prop==0)] = "<5e-05"
  names(prop) = names(p)
  V(graph)[order(names(V(graph)))]$label = paste(names(prop[order(names(prop))]),
                                                 prop[order(names(prop))])
  return(graph)
}

