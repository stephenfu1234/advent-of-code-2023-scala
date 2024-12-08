import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.HashMap

val sampleInput = "jqt: rhn xhk nvd\nrsh: frs pzl lsr\nxhk: hfx\ncmg: qnr nvd lhk bvb\nrhn: xhk bvb hfx\nbvb: xhk hfx\npzl: lsr hfx nvd\nqnr: nvd\nntq: jqt hfx bvb xhk\nnvd: lhk\nlsr: lhk\nrzs: qnr cmg lsr rsh\nfrs: qnr lhk lsr"
//val sampleInput = "A: D C B\nB: A C E\nC: A B D E\nD: A C E\nE: C B D"

val puzzleInput = "qbx: vzd jrc jzl vll\njhk: scv xkp mjn\ntqb: jgm qjn\ngff: pmg fcn jpd qgc\nnpq: xgz sfv lhf\nvxs: szs\nnzk: thm bgr hnp bgt\nddl: jpx pjc\nxvb: fzj thm qfr rfd\nbbn: fjq kld gmm gjc\nqdt: szn\ntpl: jzt ncg\nhrz: jhb ttm mms xpv\njzg: xxr\nvpd: vqg skm jrm\nnbn: jbh fkc vtc\ncxr: hld\nzdg: nqr phj\nldr: snq njr jvp dcd\nttf: jrb jch\nldt: scq bgt\nqhz: zsv\npls: hrt lzj jzg\nxbm: dzp\nsrb: xvv rnf mpg kxz\nqvs: pzm sth\nbxn: jss\nxft: ltp mkq jqs fds\nphh: rgl vjp bpx\nhsz: qxj pht nmc ttn\nmqn: xrs bqg ddz vdn\nxvv: lzn xcb\npvl: jfj\nskr: pfk zdg xff\nnlb: frd tvb qmk sfp\nsxz: bff xpx vjp qkv\ntkz: fbv fct xhn fxj\nnlc: rmt dcs vbt\nttl: bkq psx\njdz: rtr cpq rjk qhf\nrkc: prr msr zpg\nvqk: xpd\njhg: rbt\nfgb: txx\ntqv: qtr\nfjq: mfz bjj pkm\nlxx: zxl skr mrb cch\nnrg: kfz xmf\nqgm: dxn jzt rrg\nthk: xcr sqn ttm mbs\nhvk: zfp\nphz: bgr mmm hdp vnn\njtt: xvt nln\nblq: dqr nxv slg ckf\nmdn: vxs brq qpb\nzmp: phz lfr ghv cmf zcm ncr mzb\ntzx: qtr\nfjh: zbt xxr xpd zkg qxm\nrjn: zkl vth mhl\njrn: xgz ckf\nllj: ckk shz ztr\ndcs: bmp\ndtf: ddx ggm czv qck\nncn: lmt cnd drq sqs dqp\nthn: zln fbv hmz vqc\ncbx: jcl vlz xff dgc\ndtx: bsv pzf\nmvh: ftn ccj tqx\ntdk: dxj jzg\nnql: qpm glq sdl dzp\njjp: fgb zbj bhz kjn\ngdx: gvk hdp\ndrq: zvm jbt sxt tlg\ncdt: njr nxv\njpr: lgn jkc fkv\ntvj: vrx cbq fxj lbx nvt\ndrj: nqr gqf tqs ngx cdv\ncht: vfq zgd\nzsq: tvl dps zxz\ngxm: kfn bkj bql kfm\nkjb: rlm slp\njzl: qbz\nvrr: xph xrj svz mnt\njlq: bqn tbn\nvnv: xqf bms krc tzx\nkfr: kvj fbl vkp bvc\ncxb: kvj mrm zln fnz\nmmm: mfz\nczb: jqs lbx vxs\nxmf: dvs bvc tzj\nkgh: tbn vxl bmk\nfmm: bqn knp\nktf: nmf vbs rql kbb\nxls: dhc\ntks: nmf tkf kfj qvs\nmcv: hjx bdm qbr\nbsm: xsj\ntxk: fll jbc\ncck: lxf jtt dcg xlc ppc\nlzh: dps\ntfg: zjc\nqjp: nkq xtj btg gqv hlr ktk\npkm: ftn\nvkp: csh qvz pkk ssr vqk\nslg: bph\nhgj: rqp mvt\nhtv: cmj xrp bxn glp\nvln: hnp sfm\ngrr: slp nnr vbh lnz zgx\nmqf: mjg\nhlr: ddl\nsls: qtq ndh\nnrj: dpf qpm\ngnm: hjx drl\njkh: sbl\ndxg: dfd zqj tqd crg\nzkv: brd xrs mnq jrn\npzf: mkz rqp\nnnz: zvs zst sgl zhr bsm\nqhf: prd jrt zzz\ndxm: gxl qbr\ntgc: fpd nbs\nstl: cst qbz ptt\nxlc: pzm\nzxv: cls\ncrf: ftp ztp qml nxq rnl\nmgq: tlc vlh jjg vln vtc\ngqn: zbr ttc zdg xln\nppk: mkx gdc bdh\nqgc: mvt rkd thh\nmhl: hfl fbc\nttc: bmf\nqhx: rvb qkv fgx\njmq: xqf\ndfb: jkc ttj xtq\nhhv: qdl kkv gfn\nsbz: lzh drt spl kjn vqg\nbnd: msc\ncdv: ndh zkg\nzmn: phm kbg xjj\nfbl: slh\ntbq: qdr tzx rhx\ntbg: fdj vtc\ngdz: rpx vkb jhs lbq\nflk: tks fps\nnjg: bmp\nmsn: lzj\nsxh: dpj zzj lnk qfl\nxnq: srf\nfdb: jrb jrr gmv kfh\nrsp: nzz\ngcx: xjj dqx knt\nmdp: dhc ptf xzc frk\ntlc: qck vmr\nxqz: skm dpd\nphg: fts tpv fjt mxf\nftz: sbm gbt qzx\ncch: sjg bmf hjx\ndrl: qrv\nhcm: qqc jrm\nbbf: sst\nlmm: pcj mhq\nrhk: bff msp nsx dvl lsn\nptt: mnb\ngpv: hpf hmz\nktn: vqk nqj kkj\nnfc: fhn\nrbh: lhq cbl zlr mtl\ntzd: kgc\nrts: drl vvc hdx cnx\nbkh: cvb mvn tmm mrb vsh krs\nfqv: kkv\nvhp: dps djf snn crv kfl\nfrg: nnj gfn\nssr: rbt lxc phj\nrjq: mdp nxl czt xvt\nngt: cfp qml\njpm: jmb rtm sbh knt\ndqx: zfp\nlgl: dsc hgj\nnff: qkr brq phl pfz\nfkc: dhl\nxpv: msc zjc\njjr: cqp spn nsp zdx flv\nltv: sjc hxm mpz rsp\ntgb: flb knt hmc\njzm: szm ccl\nzbz: sgs bzn\nfnz: jnz gmq cdt\nflv: kkz xss\njzc: pff pdh nkz snl gqv\nmvf: dpr brv flh mkt mvn\nflj: hmr pnk phb\nhvs: mhm gqm\nnnl: zbt\nzhf: hzk ksl\nrgv: vrq csm qxq gbs zds\nqmk: flv szl mfr\nqxt: fvm rct fvl sfm\ntsc: lvz szn\npkt: xfh\nzml: qtr kdc dmm mqf\nkgl: mpj xgl dbm\ntkc: nmd fvj\npbc: dkc btt vhl\nfvr: pkh sls hxz\njmp: hdn qpb tll qsv\ntzr: mfl ppk\nhhb: hrt nmf kjn sgd\nghv: mrr\nzlr: jhn rlc\nmms: bfl pkf\nxss: qmh mjn\ngpt: vkb cjx\nkcq: jbc flh\nsbm: qkv\ndtp: mrx jhg qhk sxc\nrdb: xzf\npnr: lkq cmd jcx gvh\nxdn: mrt\nlnc: hlr mnb zsl\nhkj: blq qfr fqd\nmrx: lsc\nshz: zgd rll vnn\nxmh: xrt gdk sbm kgl chn\nrdp: ddz nvt kgk tpp\nrtv: msp flj fjh pzb\nkhc: mrr rvb mfb\nbcd: ttp jrl mkz lqz\ncmj: zjj vbs\nqhp: xqq\nztr: sjc\npkf: tdq\nhpc: xbm rgj\nnxk: nkq fhn dqc ltx rpx\nsht: krx rvt jrr lvz\nppf: pxm tbg fvj kss\nftd: mmd\nndk: txz dgt sjs\nglp: ttv hrt ghr\nxhn: vbd bbb vjj\nkzc: khf fdj bvm gbt\ngpb: lcd thh sxf\nndp: xnn szs ptt\nqds: tln qtz trg rrg\njzh: jrt msn bxn zts\nxzb: rqm rkd tqx jnx\nlvt: qcg bbf jcx mnb\nxpx: ccj fzj\nnlg: qch kxn thq bnc\ntjv: hkk kkm vds lvs\nvrl: hsn sgs\nbmx: qhg ptz\nhjv: mrt\ndqp: gkh lqt\nqkt: xsk xtj jbh zsm xvv\npbq: hcm xkp zrg pfk\nplm: dch zxl mrx\nbdm: lsc zbt\nrkm: cjq\nndh: mfr fzt gpd\nzhk: pkt bsc\nblh: zln\nlkg: nvb sbh fzt jpr\nnxl: rnz hsj tfm\nqbv: vhl zdt\nmxg: mfl\nsdl: fds vdn dqv\nlfs: qlg vkb pvl\nprb: sxt nrx\nxtc: jbd lmm\nkdx: czz\nqlb: xnn zxv vbt jgg\nppg: zgc krs zbt\nbzp: zgg crd ptn qbx\nxhx: pkt gfm vbb rsq\nzbj: phj kzl pfk pmh plm\nzhr: qck\ngmp: cmd\nkxt: pzm\nghj: hhx\nbqn: cvt\ngdd: pcj kpx kxh\ntsx: ddz bfj kvj lmt\nkrs: tbk\nggs: hjv spn ltz sth\nxrr: pzs qvz qhp dcj\nsnc: krc\npxm: vbt xlx\nhsn: tts\nnvj: hsn tks\ntnq: mgg xpp nxl\ndxk: gxl\nhdl: bsm pzp ltx nnr\nxkm: tfm bbc phb pzb\nhkk: gcx gfm bxm cbx dxn\nnjr: fbr\njxk: cxr ktz nrc dkp hht kfz\njrl: nlr rpx bkq btg\nkjv: kjd pls flk hsb\nbjj: xrs vnn gsr\nmrt: tfr\nnpm: cbq\ngjf: bsv qvn zhx vjj\nkjn: tzr\ngqm: vlx fbc\nvhl: fxt\nssl: vbs lts xls zdg\nxsl: qck slh\ndlq: jbd qnn vbn btk\nqxr: xnq gcx xdn svd\nhjk: hhm tvb\nxrp: sdf xcr jxt\nxvg: pbv sgs vnf ttr phj\nfgj: qjb kbb ktn zjc\ngnn: vzd tnt qbz\npdt: fcl tnt mfz dgs ztq bzz jgx\npsx: kfx\nrxg: gkl jbd dqx\ncqq: lmm xff lvs\nqnn: chs zgc\nzts: qnr hvk zdp\nplv: kzs kfx qmf qvn xgl sbl\nhkb: brz xbm qsv\nnmd: kvf htr fzj\nrpp: mdk kmf mmd bfj\nvml: ngs fqv kph\nhls: plj rrc\ntqx: ddx\nvnp: qdt mqf knp\nmln: ztr\nxtb: jzg\ndkh: gcz dcg\nsdn: nqj prr\npmp: jzm txz fhn dtf sxf scq\nkmm: fzj zhx dvs\nfnt: nzh\nncd: ldr khf fqd qlg nvt\nqvx: cmb vbd pll grz jhs ntj\nlzn: cxr jgt\npht: qkv bzv\nzqd: frk sgs xjj gdd\nngd: gpq ghd zmx ndk\ngbs: ltz tfg phc tvl\nzfs: shc mhq ptz hrs kxt\nqmn: dbh klt tvz\ngmv: sdn gcz\nbxc: rxz nrl qbk nvj\ndlf: jjg\ngpr: bjc zst\nbbb: rqf\nzxz: jpn\nrqz: psx vkb sst qcl lrh\nltx: hnn fjs jpd\nlhl: vqc ddx gvk nlc\nxcb: znd\nhmh: qhr\nqbk: qdt hmh glp lsc\nbhl: rqp kdx fzx\nzmk: rlk jfj\nmsr: mxl lxc hns nnl\nmtl: dgc xqf\nfzr: qxq xdg lxf\nccn: blv fhs hht\nxth: hnz kph mbj mvb\nxsx: lvz\nbjs: tqv xfh vmx qkk\ngrf: qmf cnd fct\nzdp: bxg mbg ltz\nmhm: vtc\nrnf: gjc\nfkt: vln sdx nvt qvx\npzb: ncg\njvj: fjg tvb\nbpv: dch prd xkp kfj qgz\nrvj: vhr znd fbl tcf\nsth: kfh ttr\nccg: cbn npm zxv\ntrd: xsl qmf pvl jkh\nqxj: vlx pzf pkm\nzxj: bgj rjk fmm ksl\nrnz: vgn jzk szl\nbhz: tbn fvz qcf\nghr: ltz jtf dvz\nrkd: fvm\nmsk: pkf mnl cnn\ntrg: qch\nzvm: qmf xqd\nzsm: tkc vjp qpb\nnxq: hjk mjn xss jzk\nzbk: tpg\ndcd: khf pht tnt\nhmc: gdv qln tsp qqc\nhfc: qdr\nzjx: crd klm\ncrx: gtt xzb rrc\nvth: qnj\ntbl: ttf lsc gtc flk\nbgj: fll\nnxv: bph cnd\nhht: czz\njch: mnl\nqtq: tln xls\nnmc: jjg plj\nfft: gjg mtx crx xrj gbl vdx gpr\nxxg: khc qzx dbm tvn\nthd: crv zbr rtm\nttn: lnc cmf rsp\nzsg: vdz rxg jss bmx lqs bqn\nrqr: dpr jcl pls vmx\nghf: mjx jtf zbk\npdh: xfj qpb sbm\nhpf: kgd blh mnb\nnsb: lfn zzz zhm\ntlz: tfj\ncjc: ffr zhm xhj xjs fkl\nmjz: fxt mrb jkf nqt\nfhs: sdx lnl\nfts: zhx\nxqq: pcj mjx\nvzj: bhr bsm dff\nlld: slh mmm\ncgl: bmx sls fjh pxg\nlqb: bjc bck dcf kfz\nksh: dgk lqt\nhgk: ttl brd rgl bkq\nhtr: vzd znd\nltr: hvk mtl djk\nlvs: zjc\nmxf: vzd\ntpv: mfg qbq\nqzx: cjx tpv\nnhz: rrg\nbdb: tzj gvp jpx xqr\nnsk: nrc nvt nlr\njrt: shc hnt\ndln: pvc tln zlv\nhgm: xnp jzl svb\ndmz: mnq cdk\ngzt: gfr zjf bvs\nlqd: bgj gkl mtt hng\nhdx: zdt ckr\npzs: vxl vpd jxt\nsks: tqb vbh chf\nrbt: vkg sjg\ntll: sfv nsk\ntxt: skm xzc dvz mjx\nfdj: ccl\nqsp: hnp vzd sxt\nzqf: xtb vnf zlr mkm dcg\nlnk: lpn zbk\nbnm: gnn jnr xgt xsk phh\nzgg: pmd hct\ndxx: mmm\ndsc: rmt xnp\nhhz: sdn srf jss nvb\nfmh: jhf glz hls bfj\nzzz: fll txk zjc zxl\ncll: szd nxv zvd\njhb: kfh\nvgn: zkz\nhcq: sjg jhb gnm ctp xtc\nzrq: ftd ttp qhz\nsxc: qdk\nrqf: glz prb\nqxq: tmq qbp\nvhr: jqr tfv xqj\nfkv: fgb\nxvj: jdl nxh hbh llj\nlhb: xmr tmq ncf lfn\nlhq: sth qjb\nglx: zsq ghf hhm\nhbh: ztr\nqkk: szn\ngbl: cmb\njgg: sxf jhf fzx\ndqm: bbf tzq pll skg npq\nqln: bvs\nncf: hcb xpv nsp txx\nxjm: thq npc ggv trf\nmrj: xjj qfl czt thd\nqpg: dqp zvd fvj szm dbh\ntvb: htm\nklz: zhx npm thr\nvkg: djk pmh\nctl: xhn dcf\nzmt: gnx zkg dvz dbb\nbhd: vds bnn ztp xls\nvdn: mkz\nxmc: dln kkz pqc thq xkp\ntfp: kph fcx bnn\ndcj: tqt lmm\nbfp: zdx kkj kkz\njpn: txx\nzjm: brd klz kgk\njcb: phl bll ttn xcb\npsz: cbr zlv cvb\nrlc: zhm qhr\nljx: qgc xzp pff ckf\nvlx: sfv\nnrx: hbh\nqsv: bgt\nxmj: tdb xlx\nvmx: fjg\nvqv: mdn nhm gfp qpm\nxvt: bsc fcx kxh\ntbn: nqr\nmkm: mrx hzk nmf\nfqd: lqz\nbkj: ncg zdt\nkgd: xgz\nhqr: xsp hgj scq gvp\nprq: jrc hkj kdx jzc\nqvh: mvb phb jbd\nbnn: shc ckr szx\nxpd: zjc\nxkp: czt\nqml: tbk\nvbd: zsv\nbbc: hzk ksp jrm\nrqn: gbl ncz txq kjb\ngdc: tdq qbv\ngbv: btt jtf bnd mvb nhz\nvkc: zqm dxm bmk ngs\nsjs: ptt njg pjx\nnzz: sst brz\nppr: mhm zsv\nhdp: jgt\nbnc: cvt\nctb: kll bhl dmb dlf\nlpn: qdk\nnms: dcs dff sdj\nnkz: fhs kgd\nszx: cnn qhp tmm\ndss: ztp ttm hvk\nczm: fxm hsb xvt zrx hns\ndrt: qhr csm\nfvl: hhx xvv zjr fnt knr\nkjd: zkz fqv pkt cfp\ntkx: plj\ngzb: ggt dpf sxf dbh\nrjk: msc qkk rvt\njnr: ztb ghj\npqg: dpr fjg\nlhj: hcm hjv vds qxm xnq vkc\nlqp: tcz xkm dln qdk zbz qmh\nzvs: gfp sfm\nfxj: rbj\ngfm: dkh kfl\nkkm: tfg sdf\ncnh: thr htr fjs fjt\ntpc: dzr zmp ttn fbr tzd\ndsz: ssf dhc\nrck: qhx hxm hbr kbr\nbqp: qkc spc tkx\ngjg: dxx qcl\nlnl: jgt mpz rfd\nlxj: fxj vsg phz\nmlj: ktz gjf kdp\nlbg: nqj mrj xpd frk\nxlt: dlf gfq cll qjp\nmkq: kxp rnf\nntj: xtj\nplg: tkc pcn gzk sdx\ntjs: lvz dln kgh vdf\npkh: xmr pxd\nmvx: mhl gpv bcd rpl\nmzg: bjj qvn rkd sbl xkj cbq\nkss: pll bpx phz ngh\nptf: jkf lqc lvs\njns: fmm knp\nffd: nkq xsp gfq\nkdp: gdx\nnnj: jpn\njlz: dpd hxs tbn\nmfb: fvm\nqcf: xjl pmh qjb\nkld: lld jbt stl\nkrt: vdz fjg xtq txl\nldm: phm\nddk: lfn clv kfn tpg\nvlh: gbt gpr szm chv rqm znj\nbff: mrm thh fbc\ndxn: sds htm\nttm: kcq\npfz: zjx crd gmm\nxgz: vnn\nsxf: xsj\nxkb: zrx trg\nfkk: bgd kkv nsp\nsfp: fmm nhf\nqjn: sbl\nxgt: mdm fmn\nhkq: hsn pqc kfl\nzqj: nxh\nqng: bgj\ntts: zfp vkg pfk\nckk: mns rct jhf\njzs: bkq tzd svb xcp\nnbs: mvt jgm\nrmf: zjr zcm lgl sbl vqv\nvdf: zkz jmq\nmvn: dzj bnc zxz\nmnk: pkf snc kdc\nltp: gsr ngh qrj lld tnh zvd\ngjv: vlx vng cst vrt\nmdk: jxr pxm\nbtk: zkz sls\ntgz: mkt hgs zzz glb\nsfk: njg rlm\nvsg: bhr nxh\nkxz: ztq btg\nqpb: mln\nllt: rbj xzp njg dqr\nktk: nlc bsv\ncxd: pvc fll zkz\nzfc: ddx njr\nlsx: pzb ttr bbc hhv\nrrz: qbq jcp psj fcl bjx\nrvg: ccj nrj lcj\nfcn: fmn bck dzp zxv kmf\ndvl: krx vrs bzs\nxtj: qcl\nxht: nmc cls fkc\nkkj: tkf\nzrx: zrg tsc\nzrg: rvt\nnmj: xpb zjr ggt\ncsb: gpt fqd bbb pmg fcl fvj\nmxx: fds tfv tlz hdp\nxfj: nfc mrn pvl\nmgb: zfp bdz mnl frd rdb\nbxp: phm rtm qdl\ndmm: cjq spn\nzqm: vhl vrj\npsj: gvh\nhxk: lgn nvj vbb jpn jbc\nhtm: bsc\nkrd: slp bsv mpj tnh\njzk: ncg\ncvg: rbj vzj fgx ndp\nlfz: hng\nslp: zln\nctq: jlg dpz tqv\ngmj: nmd dzr qnj qrj rnq jzm\nmkz: hct\nrhx: xzc snn rkm\nrgj: vth slh\nqdp: xpb\ntsz: rlm gmp zst qsd pcn\ngvp: thm dgk\ndhf: qbz dsc qsv cht\nxmr: cnn\nkfn: fmm crv\nnbg: ddk qvs zhk rkc nfd\nssd: nzq shd tvz gpr hvs\nbln: npn hkq rsq\nqxh: lvx cnd spc bjc\nkll: pxk sxt txz zcm\nkxd: dfd cls bhl\ntnt: bqg\nchf: sbm nrj\nbdz: xvx tfr\nqdx: nrl dsz hfc pnk\nztp: gtc\nftn: jbh\nvll: bph jfj\ntmr: jch pzb htm\ncvb: xsx\nffn: gzk spc nzh xbm grz\nspl: zgc bms\nqtz: zjf hdx hzk fps\nxsn: ngh mrr qcl sjc\nqlh: dgk xlx ktz sks\ncpc: ttj btt vbn glx\nplk: qch\njrc: lhf nhm\nnht: qml jpn xtq\nszd: sfv\npjc: hld\nspc: xph tkx\nlhf: hfl hnp\nrfz: thm jnx bjx rpn\ngzq: bdz qrv frg gjd mqf\nrzc: rgf mdf vmr rzp\nfjn: mtl ggv\njzn: nhf zhf rdb\nzhh: qqc\nshd: jgm dzr xpx\nknr: vfq mrr\nsvb: khf znd\njvk: gpd mfr\njqs: txz\nvxk: pmc qxm ltz\ncfm: ctl fbc mfz hls\nmrq: lzj vqg xtx mtt\nqdk: jbd\nrvb: mpj\nnjz: zkl gmb xht\nqxm: lxc\nljg: zdx fps qng fjn lzh\ndbb: mjn cjq\ncpq: snn qhk prr\nkvf: fzx qvn qlg\nhns: kfl\nnqb: xtc fqv tfp ggs\nxzf: fsq bdh lvs\nqgz: xbt jch\nzjf: gqf zlv\nxhl: qrp pxm lhl\nqmx: cbr cxc tdq\nbzs: prr tfr\njdx: ljj tbk zrx nxc\nsqs: qlg fzx nmc cmd\nktv: ttb nzz qbq xhl\nxts: fgb kkz vxl bdm\nhcl: jxk kdp tkg sbl\nbvx: xzc sdc dcj qch\nfkl: vnm jvj\nfhz: trq snc hjk tbk\npff: zkl pzf\nmjc: kfh jlg lfz lpn\nkbr: pjc xsj\nhsj: pst bgd jrr\nfpk: qmh qbp ljj sqn\nqls: djk pcz gml trq fsq\nhdn: fvm kdx jdn\nncz: nfc zpz\nchn: jrn jcp czv\nkhf: sfm\nbrz: rlm\nlqz: vkb zvs\ntqd: dxx\nrhn: xfd rpl zsm nrx\nkfz: gfq\nzdt: ttc\nspn: vbs mhq\nhng: bvs sql\nfbg: jmb frk cfp bgj\nptn: blh gsb zjx\nszp: vdx\nqct: dqv npq gmp ccn\nfjt: xcp\nxrt: vrg sdj dbm\nmbt: gsh htm xxr\nnzq: cnh ztq dvs fkt\nxzp: fts\njgq: qdp lkq\nzxk: cfp lgn zkz zbz\nljj: lhq qrv\nqkr: ksh xph vqv lhl\nrsq: jtf pqg\nrbj: mns\ngch: sfp mzh xxr tzr nnl\nhxm: bvc\njmb: htm vlz\nrmh: hld\nvjn: lts drl\nsfv: nhm\nptj: rdb jmq ptz dmm gqf\nlsn: zfp gmv\nhxz: qng\ntmm: cvt gqf\nfsq: fgg\ndmb: klt mhm zsv szp\nrpl: czz\nsqn: xxr msn xcr jvj\nzzj: nnl gxl kxt\ncnn: gtv\nnpn: phm txl rrg\ndsq: hmh pcj txl lfn\nbct: nxv qkv\nfpz: pqc jhk jns\nqjf: fpd phl jxr qsp gsr\nkbg: jtf ttv\ngnx: fkv nqj\nxsp: vmr\ngtf: fpd ncz lbx zgd\nkgx: pqg hzk knp zmt xbt\ntsp: vkg mrx pmc\nvdj: txz fhn xcp hzx\njxj: ppg szx gpd zbk kph zxl\nnzb: ffd hbr xvb hgm\nfgg: bnd hhm cvt\ntgf: blh xdx vqv mfg\ntpp: dgs lfs pjx zmk\nhbz: gpm txl vrs\ntxq: qbq hfl lnl\nbgt: szs ftd\nhzx: mmm scq ddl rxs dbq nlr\nkvr: jqr pvl crd lpj\nqrl: mjg nvb tdk ldh\nftp: jbc jrm\nxqr: jhs mdf lnl\nxkj: rqp cjx mfb\nmnt: rfd mln\ngtc: crv cjq\nvrt: szm ttb tpq\nqhr: csm\nxxx: knr jpd dhl\nbpr: rqf lzn nbn gfp\nlhk: ppr jxr mns jgg jzc\njnx: bvm kgc rll\nhhg: mpz bzv jfj snq brd\nvng: vxs lcj cmd\nddz: rct jpx\ngsg: qrj dxx tqd\nzjj: snn\nkfm: jcl\nlxf: mrt\nmkt: cxc vml jrb\nqqf: tgc jdn ftn\nmmd: jbh\nzkg: kxt\nfgf: sxc hrs trf rkm\njnz: ckf\nkzp: bln cbl rhk tbq spl zjj\ntcf: hqz ckk dqc fbl\nqnr: gqf psz rhx\ncnx: xkb cvb\nsdx: scq\ngkh: njg nnr blh\nzrr: hct zvs sfk dvs\nghd: xfb phz hhx\nrgl: mrm tlg\nqpm: fvm\nflh: djk gml\ncnb: zfs hrs qhg bms\njsd: hkq cjq xjl dsz\nmdm: ppr ghv kxz\npcx: nkz gfp ppr vsg\nsvd: txk\nbhj: gqf phb pxg mvz\ncdq: svd bsc\nvxn: tfm qqc\ncqg: vfq tbg hxm rzp\ntvn: cnd\nknt: mrb qnr\nsjg: kfh dxm\nxcr: sql\ndkc: dxk szl sql\ngzk: nbs\nglf: jcl jrr cdq qln xpv\nktz: zpz\nnnr: dqr\nnln: fxt mkx mjg\nfjs: qck dkk\ntkg: qzx dqv klm fjt\nhhj: sql bmk krs\nqtn: rxg zds vsh szh cnx\nlfr: xhp hdn gjc vjp\nfgx: qjn pmd bzz\nvxm: xdn cfs tvl ctk zdx mbs\nqpp: fbn qfr dmz ldt vnm\ntqt: frk sls\nfbn: zsl zvs\ndgt: mfb chf czz\nbrv: txl qtq frg\npdg: fjq bzz xmf nkq\nflb: hng mbg vrj\nbxm: mbj\nrxn: sds qng kbb mbg\nrqm: bsv\nbgd: qml dzj\npfl: dpf gmm\nsdc: ggv lhq qbg\nrnl: rbs jpr fpk\nxrj: hnp sst\nkqc: tmr lnk lsn ncf\ncrg: jqs nxv khf\nsmq: bbb blv klt rlk sfm\ndhh: jnr ltx dfd xfb qhz\nbvm: jdn\njgx: jpx rrz dbh\nthm: kfx gjc\nqcx: psj mkz fgx kgd\nqsj: gcz mxg ttg mzh\nphc: fxm\nvdz: zbr kxh\ngfn: bkj\ngzn: vgn rql tzx bjs\nglb: hjx tpg kfm\ntrl: pkf thq\njhn: fzd\nlml: lxj cnh jgq gmm mnt dqr\nfpd: plj\ngpq: jbt vjj\nvbb: ttv dxj ggv\nqrj: skg\nfhq: lfz gsh fkl bdz\nztk: jbd jhb fqv\nvzh: xhp gbl ghv npm mdf\nnxc: hxz vrj\nxqf: gpm\nchs: mkx mjg tqt\nxph: kjb\nhfn: ztk vnm mfr lvz\ndpr: bxk\nmhq: kfj\nzmx: ccj\nsnq: dfd zfc\nrbs: lzh pcj tpl dpj\nlkq: dkp\nkjl: lcd rvb bct psj nrc\nkkh: ttj dps qkk kcq\nsbh: fbg hjk\nhrs: svd msc\ndkr: hvs mkq glz nnr\nkdc: tvl mrx\nlcd: dbq jgm\nbxg: qmh lqc\nrrs: rvg ppf jxr\nbfl: xts mbg\nqhk: hhv rvt hnt\ndqc: xdx gjg\nktg: mvt ghj tzj mzb dtx ctl nmj\nbzn: mbj hnz lpn\nhgs: kpx jzt cmj prk\nvjj: bfj\nvnf: mbg jvk\nncr: fds dhl pfl\nkpb: tlc tvz tll zrq\nmtx: bvc dff\njck: xtb gpm jhn msn\ngdk: hdn dzr mlj\nbll: mvh dtx prb\ncbn: bhr vzs lqt\nppv: vnp knt plk nxq\nzlv: kfh\nkmf: czv dkp\npxb: qbv thd gcz\ndgc: jss ssf\nsnl: hht jdn zfc\nrql: dpr rnz\ndzr: bbf\nlbj: zvm lpj dkk vll\nvmd: tdq kkj qdt\nntz: fzt vqg plk czt hhj\ngfr: mfl\nxjb: nxh khc fts pjx\ndch: zbr\nkzs: ccj hld mpj\nvhb: zqj fdj glq ggt\nxqd: cdk dgs mrm\nxhj: qcd xkp sgd\nvtb: hnz tpl hsn\npmt: fpz vtb sds nsb\npxg: lbg rhj rrg\nnlv: ngt jmq fzr qcf vmd\nmnl: dqx\ncdk: mfg\nzgx: fgx dkk rrs\ntfv: zvs lbx bzv\nsgq: rlm klt nzh\nkpx: ngs\ntzq: slh pxk zvs mfb\npnd: dxj gsh mnk xxr\npst: gtv\nbjf: zhh jkc hmh\nprk: dzj gml\nvpn: bdm pkk hfc dxk\nbrq: hmz mrn\nmns: fkc bqg czb kfz\nfps: zhh\nggm: tlz tsx zdl\nzsl: bhr\nrmt: xsk fnt\nhcb: fgb pkt\njvd: gnn xfb dvm zgg njz\nngs: kph\nrlp: lqs xtb zmn kxn hsb\nprd: phj\nbqg: bvc\nrxz: xqz vdz gxm lqs\nvhg: kvj lqt hgj rpx\ndpz: vrs xxr glb\nmrm: ftd\ngkl: bxn jhg fjn\nxnn: jxr bkq\nnzg: sxc qgz kxh vbs\njhf: ccl\nrhj: ghf gfr szh\nqsd: ntj pjc bkq jkh\nfvz: lvz lmm tgb\nmrr: xhp\njvp: lzn qck gzk\njqr: snl rqf jhf crd\nbzv: slg\npmc: lqs\njdl: lrv psj mpz tvn kxd\nmbn: dqv jrl vdn ntj\nxpp: jns tpg\nfcx: shc kxn mvb\nmjk: dhl sfk rll hfl\nnsp: pst\nqbp: dfb\nqdr: fxt\ndpj: jss zhk fzt\ncfs: cxc rtm\njcx: lhf\ncst: vth jbt\nldh: qcf vkg rgx\nvnh: vrj gdc qml qnn\nhgh: ctq tkf jkf bzs\nzgd: bmp rpl\ngbt: zhr rll\nzkl: jpx\nxjs: csh mxg cpz\nfrd: hnz rkm\npfx: qfr tzd hct\nbjx: gvk vnn\nlcj: nlr\nmrn: dhl jgt xpx\nskg: zpz fds\ncmf: fbr grf\ncsh: kxn zfs\ntdb: ldt ktz\nrqd: xsl qhz tlz szd sgq\ndjf: xqg mfr bdh\nfxm: dcg mtt\nttb: ttl rsp klm\nvnl: fbv gtr jzl ktk\nszk: hlq rtv kfm jvk\nbvs: ttv\nfjg: nvb\nsgd: ttg jnv\nlsc: pxd ckr\nmzh: kbg vnm\nrpn: zjr gdx cht fnl\nsds: szn\nkpj: hns trf phm dbb\nxgl: nms glz nrx xcb\ndjz: fbn pvl jgp ccj\ngmb: rzp rrc hlr\nmpr: pbv qgm zts hxs\ndcf: kfx xjp\ndbq: dgk\nvnj: fhn czv rfk ngh\nppc: pmh msk qvh trl\nxsj: jjg\nfct: tkx tfj\nnhf: bxk\ndqr: hdn\npfg: xjl rtv jbd vdz\nszm: qbq\ntpq: rlk lmt\ndbm: tqd\nqch: ttc\npcj: pkh\nqcd: qdr hrs rrg\nvbz: jrt ttf ksl cbl\nrfx: vqc lgl mdf zxv cmb\nrvl: jrb btk tmq clv\nxdx: mmd znd nhm\nlqc: ckr\ndjv: qbg lvz gbs xmr lts\nfsg: mpg xpx bmp fbr fqd\nhnx: grr rmh fjq blv\nlbq: lmt vrx\nxqg: ssf thd sds ldm\njnv: dch bxk hhv\nkdt: ljg hbz nvj jhk\nmvz: kkj trg ntz\nctp: nmf vnh msc\nxnj: pcz dpd lxc csm vlz\ngbj: bxm jtt spl gnm\nvtp: vzj zsl nrj cst\nphm: tmq\nhxs: pzb\nkgk: gmm hnn gqm\nnsx: qtr gzt fkv cdq bfl\nmpt: xjj zrg dxk ltr\nvzx: fqv jpn hnt ghf\nlrv: jcp hsz nfc\nchv: xnp xdl gpq\nblt: tfg ttc hhm jzk\ncdn: sgs mqf nhf gtc\ntqs: mfl\nbbk: mms bms zxz vqk hnz tnq\nmnq: zpz slg\ngdv: npc tks bzn\nvbn: zhh xsx txx lfz jlq ppj\nqqc: gtv\nrnq: cjz jgq\nffk: bbf rmh rgj pmg\nvcl: qdp vsg ttl ghj thh\nrlq: jkc xsx tdk lfc\nvzs: pjx dpf xqr\nvds: dps\njcj: pkm gpt zmk hkb\nxjl: bmf qmx\nnpc: vhl gcz\nqfl: nnj fkv\ndlt: mbt bxg ksl mjx\ndcx: drt nxc bnc lxf\ngsb: sdx ttl cxr dzp\nffr: bfp pcz jzn vjn\nxqj: fnl bvm qnj\nzxl: pkh\nqbg: hrt\nthr: bdb szp\ncbq: dzp\nmpg: gpv rxs ztq\nbzz: zqj\nzcp: kbr lzn tzj xsk\nxdl: zdl rlk\ncqp: xvx nqj fzr cdv\nqhg: ngt cpz\nqnj: cls\nqkc: pmd jgp jkh\nkbb: xtc\nptz: bvs\nnqr: pxd\nlvx: dlf gdx dqv nms mxf\nrgx: vxn csm pxd dxj tkf\nxfd: llj fzj bct\ntmv: bql ntt ftp gfr kkv\nrtr: nhz pzm nnj zhf\nztb: zgd zst tvz\nvvc: vdf cch szl jlq\njgp: nrg mxf\nbqt: qmf tdb dxg fqd\nxln: xfh snc tsc\nzgl: qgc zcm rfk pfl\nnfd: dkh kdc xqz\nqvz: plk trl\nzvd: njr\nvrq: gpd ldm mkx\nlgn: nht\nbpx: jxk ktk\ntqz: zgl vbt lcj\nxkz: qpb zjx szs dgs\ndsm: rct zpz pjc hnn\nppj: plk gnx hng\nkzl: cbr vrl\nvlz: gsh\nxtn: qdp zjm cdt ftz fpd\nqcg: bqp ksh xmj\nhkv: vnp pbv qbr\nsdf: qjb vxn\nkxp: znd rll qqf\nsgl: brz qjn gfp\nlts: bmk hsj srf hnt\nzdl: hld\ntfm: cfp\nbck: pmd klm gmp\npkq: xqq xln msn cbr tqs\nmxl: bql fkk qdl zfs\nmzb: lkq\npnk: zhm bgj\nskm: vxk\npcn: jcx qbq\nfrl: kkm nxq jhn jhb\nvbh: btg nrj\nhct: xcp\nlpj: hmz vdx\ntlg: rsp zmx\ngvh: sdl dqc xdl\nglq: glz lcj\nljb: grz gjs tfj sdj\ndmk: pcz vbs xnq pmc krx rgd\nrxs: ptt\nlfc: qkk ttg ssf phc\nfnl: spc hbh ccl\njlg: sfp kkv\nntt: zjj gml lfz\nzds: vrl nsb\nhsb: xlc\ndkk: jrn ftn\njcp: psx nrc\nvdx: dkp\nkrc: xzc\nblv: hxm vll rzp\ngtt: xdx cjx nzh\nsjx: vbs krt qmh hmc\nhbc: crx jqs bjc lbq fnt\ndvm: kgc xzp qsv\nzpg: bxk dpd kkj\nnrl: tln thd xpp\nmsp: xff xfh\nxtx: cxd vgn hmh\nqgs: cqg xpb mfg jhf dmz\nttp: mhl bph\nbdh: vxl\nttv: tfr\nqrp: sjs sdj rmt\nfpt: dvs fbv kmm rpl\nfmn: cht tqb\ngtr: hpc grz dqv\nnqt: hfc pbc ttr\npzp: pfx tvn gsg\nbql: mcv\ngqv: hnn\ngmq: szd stl gfq\nvqq: vqc xhp rnq xsp kgk\nscv: hjv mrt\nszh: rlc qbg cxc fzd\nbgr: sst sbl\nkhm: zjx czz gsr tqx\nrgd: vrs hhj xkb\nsqv: vdf hxz cpz btk\nvsh: flk jns fzd\nsvz: dqp vnl xlx jnz\njlj: szp ccg xgt kbr tqz\njxt: txl rkm\nvrx: vfq xpb\nqdl: rtm\nrfd: jhs\nksp: scv ztp dss\ncbl: bsc fsq\nxxv: tkx xxx gsg rrc\nfqb: qhp gxl cqq xjl rjk\nvql: glb pbv chs gpm\ncnk: vrx rjn bjx mdk\njfq: qrv fvr bjf kzl\ncjz: dgk dbq skg\ntcz: rjq jkf hdx\npvc: krc bmk\nxbt: ttj trf\nhqz: mtx tfj nrg\nhlq: xvx dhc fll\nxjp: qmn phl zdl vth\ngjs: pht jnz vrg\nbbs: kfj vjn hkv vhl\nxvx: zgc\nhmr: bnd nhz pfk\nvmr: mzb\nbkq: rqm\nxdg: pst cpz qmx\nfcl: sgq\nfdp: sxf nmc fzj jgq\nctk: pxb prd bxp\ngjd: xnq prk fxt\nfzd: mtt\nmgg: phc mcv hxs xlc\nclv: krx jzt bmf gfn\nvrg: gqv zmx zhr\nngx: zrg hsn vmx dzj\ncmb: cnd\ntnh: fdj tpq\nkgc: jhf\nlrh: hpc vbd cdk\nlzj: dvz\ntzs: hcb pbq kpx hns jhg ldm tbq jlz\nlnz: kdp stl rmh\npxk: jpd gvk htr\nzqz: rnf vkb dcs dff nbs xrs\ntrq: gtv qbr\nrfk: hbr tqx\ngqf: tqv xtq\npqc: zqm\npkk: qbp tbk xdn vnp\ntrf: kxt\nbtt: cjq mxg\nxfb: pll\nsrk: cfs skm lqc hfc\nrgf: mhm ggt xmj xnp zhx mln\nggt: rxs\ndpd: mbj srf\npmg: gpb\nmbs: cpz bxm tqs qln\nhbr: sjc\nznj: tgc bjc hhx\nttg: jrt"

def parse(input: String): mutable.HashMap[String, Set[String]] =

  val graph = mutable.HashMap[String, Set[String]]()
  input.linesIterator.foreach(line =>
    val s"$vertex1: $right" = line: @unchecked
    val edges = right.split(" ").map( edge => List(edge, vertex1).sorted.mkString("/"))

    val vertex1Connections = if graph.contains(vertex1) then graph(vertex1) ++ edges.toSet else edges.toSet
    graph(vertex1) = vertex1Connections

    right.split(" ").foreach(vertex2 =>
      val edgeName = List(vertex1, vertex2).sorted.mkString("/")
      val vertex2Connections = if graph.contains(vertex2) then graph(vertex2) + edgeName else Set(edgeName)
      graph(vertex2) = vertex2Connections
    )
    
  )

//  graph.foreach{case (vertex, edge) =>
//    println(f"$vertex [${edge.mkString(",")}]")
//  }
  
  graph
  
var counter = 1
//@tailrec
def vertexToContract(graph: mutable.HashMap[String, Set[String]]) : String =
//  counter += 1
//  if counter == 300 then
//    println("counter reached")
//    return "graph"

  val vertex = graph.keys.toList(scala.util.Random.nextInt(graph.keys.size))
  vertex
//  if graph(vertex).size > 3 then
//    println("vertex found")
//    vertex
//  else
//    println("trying again")
//    vertexToContract(graph)

@tailrec
def edgeContraction(graph: mutable.HashMap[String, Set[String]], supernodes: Set[String]): mutable.HashMap[String, Set[String]] =
  // we want a vertex to have 3 edges as they are weighted 1 only
  // take the first two connected vertices with more than 4 edges or more each
//  if counter == 300 then
//    println("counter reached")
//    return graph
//  counter += 1
  
  // if only 3 edges left then finish, these will the wires to cut - this might not be right e.g. 3 nodes triange, cut all creates 3 sub graphs
  if graph.values.map(_.size).sum == 3 then
    return graph

  // when only two nodes left
  if graph.keys.size == 2 then
    return graph

  // or if we're only left with vertices with 3 edges
//  if !graph.values.map(_.size == 3).toList.contains(false) then
//    return graph
    
  val contractedGraph = graph.clone()

  // pick a random vertex and contract one of its edges
  val vertex1Name = vertexToContract(graph)
//  println(f"Vertex 1 - $vertex1Name selected for contraction")
  val vertex1Edges = graph(vertex1Name)

  val isVertex1SuperNode = vertex1Name.contains("/")

  // lets just take the first edge
  val edgeToContract = vertex1Edges.head
//  println(f"Vertex 1 - $vertex1Name contains edge $edgeToContract and has been selected to contract with")

  // as the edge name is a concatenation of the connected vertices, we need to isolate the actual name of the vertex
  // e.g. A to B with edge "A/B", we need to just refer to B
  val vertex2Name = edgeToContract.split("/").filterNot(vertex1Name.split("/").toList.contains(_)).head
//  println(f"Edge $edgeToContract has been parsed and refers to connected vertex2 $vertex2Name")

  // does the edge refer to a supernode
  val isVertex2Supernode = supernodes.exists(_.split("/").contains(vertex2Name))
//  if isVertex2Supernode then
//    println(f"Vertex2 $vertex2Name is a supernode with name ${supernodes.filter(_.split("/").contains(vertex2Name)).head}")
//  else
//    println(f"Vertex2 $vertex2Name is not a supernode")

  val vertex2Edges = if isVertex2Supernode then graph(supernodes.filter(_.split("/").contains(vertex2Name)).head) else graph(vertex2Name)
//  println(f"Vertex2 edges found $vertex2Edges")

  // create the supernode
  val supernodeVertexName =
    if isVertex2Supernode then
      (vertex1Name.split("/") ++ supernodes.filter(_.split("/").contains(vertex2Name))).toList.sorted.toSet.mkString("/")
//      (vertex1Name.split("/") ++ graph(supernodes.filter(_.split("/").contains(vertex2Name)).head)).toList.sorted.toSet.mkString("/")
    else
      (vertex1Name.split("/").toList ++ List(vertex2Name)).sorted.toSet.mkString("/")

//  println(f"creating supernode $supernodeVertexName")
  val supernodeEdges = vertex1Edges ++ vertex2Edges

  // filter the supernode edges to remove self loops
  val supernodeEdgesNoSelfLoops = supernodeEdges.filterNot(_.split("/").forall(supernodeVertexName.split("/").toList.contains))
  contractedGraph(supernodeVertexName) = supernodeEdgesNoSelfLoops
  
  // need to also remove old supernodes
  val updatedSupernodes = if isVertex2Supernode then 
    supernodes.filterNot(_ == supernodes.filter(_.split("/").contains(vertex2Name)).head).filterNot(_ == vertex1Name) + supernodeVertexName 
  else supernodes.filterNot(_ == vertex1Name)  + supernodeVertexName

  // also handle if any of the vertices are supernodes themselves
//  contractedGraph(supernodeVertexName) = supernodeEdges

  // remove the two vertices used to create the supernode
  contractedGraph.remove(vertex1Name)

  if isVertex2Supernode then
    contractedGraph.remove(supernodes.filter(_.split("/").contains(vertex2Name)).head)
  else
    contractedGraph.remove(vertex2Name)

// is it correct to always pick first edge or should this be random too

//  contractedGraph.foreach { case (vertex, edge) =>
//    println(f"$vertex [${edge.mkString(",")}] ${edge.size}")
//  }
//  
//  println()
//  println(f"supernodes: $updatedSupernodes")
//  println()
  edgeContraction(contractedGraph, updatedSupernodes)




def partOne(input: String) : Boolean =
  val graph = parse(input)

  println(f"Starting edge contraction")
  val contractedGraph = edgeContraction(graph, Set[String]())
//  contractedGraph.foreach { case (vertex, edge) =>
//    println(f"$vertex [${edge.mkString(",")}] ${edge.size}")
//  }

  val remainingEdges = contractedGraph.values.flatten.toSet
  
  if remainingEdges.size == 3 then
    println(f"Unique edges left $remainingEdges")
    val componentsProduct = contractedGraph.keys.map(_.split("/").length).product
    
    println(f"$componentsProduct")
    true
  else
    println(f"Unique edges left $remainingEdges")
    false

  
//(0 to 10).foreach( i =>
//  println(f"Run: $i")
//  partOne(sampleInput)
//)

(0 to 10).foreach( i =>
  println(f"Run: $i")
  val complete = partOne(puzzleInput)
)
