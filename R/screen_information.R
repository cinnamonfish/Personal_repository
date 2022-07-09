setwd("Z:/home/yutianyun/data/CRISPR/ftp.kobic.re.kr/information")
library(data.table)
getwd()
screen = fread("screen_information.tsv")
dim(screen)
head(screen)
library(dplyr)
unique(screen$CAS9_TYPE)
unique(screen$CELL_LINE)
unique(screen$PHENOTYPE)
unique(screen$SCREEN_TYPE)

summary(screen$PHENOTYPE)
table(screen$PHENOTYPE)

filter(screen, gRNA_DATA==1)
filter(screen, CAS9_TYPE!="CRISPRn") 
filter(screen, CELL_LINE=="K562") 
filter(screen, CELL_LINE=="K562", CAS9_TYPE=="CRISPRn") 

cell = fread("ftp.kobic.re.kr/information/cell_line_information.tsv")
nc = cell[which(cell$CANCER=="Non-Cancer")]
#fwrite(nc, "Z:/home/yutianyun/data/CRISPR/220628/non_cancer_cell_line.txt", sep = "\t")

workdir=/home/yutianyun/data/CRISPR/220628
info=/home/yutianyun/data/CRISPR/ftp.kobic.re.kr/information
for gene in $(cut -f 1 $workdir/non_cancer_cell_line.tsv)
do grep -w $gene $info/screen_information.tsv
done > $workdir/screen_info_non_cancer.tsv

getwd()
library(data.table)
sc1 = fread("220628/screen_info_non_cancer.tsv")
names(sc1)
sc1$CAS9_TYPE|>unique()
sc11 = dplyr::bind_cols(PHENOTYPE = sc1$PHENOTYPE, 
                        EXPERIMENTAL_SETUP = sc1$EXPERIMENTAL_SETUP,
                        PERTURBARGENS = sc1$PERTURBARGENS)
unique(sc11)
sc_viab = sc1[which(sc1$PHENOTYPE=="Viability")]
#fwrite(sc_viab, "220628/screen_info_viability_nc.tsv", sep = "\t")
sc_viab$CELL_LINE|>unique()
sc_viab$CAS9_TYPE
lib = fread("ftp.kobic.re.kr/information/library_information.tsv", sep = "\t")
names(lib)
lib$LIBRARY
lib$LIBRARY_NAME
lib$AUTHOR
lib[which(LIBRARY_ID%in%sc_viab$LIBRARY_ID)]$LIBRARY_NAME
lib[which(LIBRARY_ID%in%sc_viab$LIBRARY_ID)]$AUTHOR
lib1 = lib[which(LIBRARY_ID%in%sc_viab$LIBRARY_ID)]
dplyr::select(lib1, c(LIBRARY_NAME, LIBRARY_ID, AUTHOR))
lib[which(LIBRARY_ID=="lib7")]

library(data.table)
setwd("/home/yutianyun/data/CRISPR/ftp.kobic.re.kr/information")
sc_viab = fread("../../220628/screen_info_viability_nc.tsv")
cell = fread("cell_line_information.tsv")
cell1 = cell[which(cell$CELL_LINE%in%sc_viab$CELL_LINE),]|>
  dplyr::select(c(CELL_LINE,TISSUE,CANCER,NOTE))

grep("HAEMATO",cell1$TISSUE) #"$" returns a vector


ew1201 = fread("../batchcorrected_zscore/ew1201.Sanger.gene_bcscore.csv")
dim(ew1201)
hk = fread("C:/Users/dell/Desktop/files/Housekeeping_GenesHuman.csv")
dim(hk)
hk$Gene.name
a = dplyr::filter(ew1201, HGNC%in%hk$Gene.name)|>na.omit()
plot(a)
sum(ew1201$ew1201.PVAL|>na.omit()<0.05)
sum(a$ew1201.PVAL|>na.omit()<0.05)
#fwrite(a, "../../220628/housekeeper_gene_ew1201.tsv", sep="\t")

a = fread("../../220628/housekeeper_gene_ew1201.tsv")
