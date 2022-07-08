heatdir=/home/yutianyun/data/CRISPR/ftp.kobic.re.kr/heat_file
genelistdir=/home/yutianyun/data/CRISPR/220628
common_gene_list=$genelistdir/genelist.txt

# remember to change to unix file format

genelist=$genelistdir/

for gene in $(cut -f 1 $genelistdir/mapk1_string_protein_annotations.tsv)
do grep -w "$gene" $heatdir/ew12.PubMed.1.txt
done > $genelistdir/mapk1.txt

eif4a3_string_protein_annotations

for gene in $(cut -f 1 $genelistdir/eif4a3_string_protein_annotations.tsv)
do grep -w "$gene" $heatdir/ew12.PubMed.1.txt
done > $genelistdir/eif4a3.txt

for gene in $(cut -f 1 $genelistdir/abl1_string_protein_annotations.tsv)
do grep -w "$gene" $heatdir/ew12.PubMed.1.txt
done > $genelistdir/abl1.txt

heatdir=/home/yutianyun/data/CRISPR/ftp.kobic.re.kr/heat_file
wd=/home/yutianyun/data/CRISPR/220628
for gene in $(cut -f 2 $wd/genelist.txt)
do grep -w "$gene" $heatdir/ew12.PubMed.1.txt
done > $wd/TPresult.txt

for gene in $(cut -f 2 $wd/canonical_drivers.txt)
do grep -w "$gene" $heatdir/ew12.PubMed.1.txt
done > $wd/canonical_result.txt

#for description in $(cut -f 5 $wd/string_mapping.tsv)
#do grep "ribosom" $description
#done > $wd/ribosom-res.txt
grep "ribosom" $wd/string_mapping.tsv > $wd/ribosom-res.txt
