ant clean-all build-all
ant hstore-prepare -Dproject="microexpnoftriggers" -Dhosts="localhost:0:0"
ant hstore-prepare -Dproject="microexpftriggers" -Dhosts="localhost:0:0"

ant hstore-prepare -Dproject="voterdemohstorewXsYY" -Dhosts="localhost:0:0"
ant hstore-prepare -Dproject="voterdemosstorewXsYY" -Dhosts="localhost:0:0"

python ./tools/autorunexp.py -p "voterdemohstorewXsYY" -o "experiments/0806/voterdemohstorewXsYY-1c-90-0806-site10-perc.txt" \
--txnthreshold 0.90 -e "experiments/0806/site10-0806-demosuite-2.txt" --winconfig "tuple w100s10 (site10) perc_compare" \
--threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --hstore --hscheduler --numruns 1 --perc_compare
python ./tools/autorunexp.py -p "voterdemosstorewXsYY" -o "experiments/0806/voterdemosstorewXsYY-1c-90-0806-site10-perc.txt" \
--txnthreshold 0.90 -e "experiments/0806/site10-0806-demosuite-2.txt" --winconfig "tuple w100s10 (site10) perc_compare" \
--threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --hscheduler --numruns 1 --perc_compare

#h-store
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --hstore --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --hscheduler --numruns 1 

python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --hstore --hscheduler --numruns 1 
#python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
#--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 0 --hstore --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 10 --hstore --hscheduler --numruns 1
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 100 --hstore --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 1000 --hstore --hscheduler --numruns 1
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 10000 --hstore --hscheduler --numruns 1   
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 100000 --hstore --hscheduler --numruns 1   



#s-store weak recovery

python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --hscheduler --numruns 1 
#python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
#--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 0 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 10 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 100 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 1000 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 10000 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 100000 --hscheduler --numruns 1 



#s-store strong recovery
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --hscheduler --weakrecovery_off --numruns 1 
#python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
#--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 0 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 10 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 100 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 1000 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 10000 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --groupcommit 100000 --hscheduler --weakrecovery_off --numruns 1 

#h-store
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 10 --hstore --hscheduler --numruns 1
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 100 --hstore --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 1000 --hstore --hscheduler --numruns 1
python ./tools/autorunexp.py -p "microexpnoftriggers" -o "experiments/0810/microexpnoftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 10000 --hstore --hscheduler --numruns 1   

#s-store weak recovery
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 10 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 100 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 1000 --hscheduler --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 10000 --hscheduler --numruns 1 


#s-store strong recovery
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 10 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 100 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 1000 --hscheduler --weakrecovery_off --numruns 1 
python ./tools/autorunexp.py -p "microexpftriggers" -o "experiments/0810/microexpftriggers-1c-90-0810-site10.txt" --txnthreshold 0.75 -e "experiments/0810/site10-0810-groupcommit.txt" \
--winconfig "" --threads 1 --rmin 1000 --rstep 1000 --finalrstep 100 --warmup 10000 --log --logtimeout 10000 --hscheduler --weakrecovery_off --numruns 1 
