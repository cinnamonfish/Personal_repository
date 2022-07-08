

| Syntax      | Description | Test Text     |
| :---        |    :----:   |          ---: |
| Header      | Title       | Here's this   |
| Paragraph   | Text        | And more      |

```R
{
ew63 = fread("") # not in the data folder ???
dim(ew1201)
hk = fread("C:/Users/dell/Desktop/files/Housekeeping_GenesHuman.csv")
dim(hk)
hk$Gene.name
a = dplyr::filter(ew1201, HGNC%in%hk$Gene.name)|>na.omit()
plot(a)
sum(ew1201$ew1201.PVAL|>na.omit()<0.05)
sum(a$ew1201.PVAL|>na.omit()<0.05)
fwrite(a, "../../220628/housekeeper_gene_ew1201.tsv", sep="\t")
}
```
