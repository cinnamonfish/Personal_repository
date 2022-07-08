
### This is a table
| Syntax      | Description | Test Text     |
| :---        |    :----:   |          ---: |
| Header      | Title       | Here's this   |
| Paragraph   | Text        | And more      |

### This is some R code
```R
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
```
### This is a footnote
Here's a simple footnote,[^1] and here's a longer one.[^bignote]

[^1]: This is the first footnote.

      Add as many lines as you like.
      
[^bignote]: Here's one with multiple paragraphs and code.

    Indent paragraphs to include them in the footnote.

    ` here is some code `

    Add as many paragraphs as you like.
