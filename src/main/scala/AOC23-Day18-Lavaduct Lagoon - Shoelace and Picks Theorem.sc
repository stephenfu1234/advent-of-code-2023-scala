val sampleInput = "R 6 (#70c710)\nD 5 (#0dc571)\nL 2 (#5713f0)\nD 2 (#d2c081)\nR 2 (#59c680)\nD 2 (#411b91)\nL 5 (#8ceee2)\nU 2 (#caa173)\nL 1 (#1b58a2)\nU 2 (#caa171)\nR 2 (#7807d2)\nU 3 (#a77fa3)\nL 2 (#015232)\nU 2 (#7a21e3)"
val puzzleInput = "R 6 (#0e4c90)\nU 2 (#5b83a3)\nR 7 (#1a3a90)\nU 2 (#64e9b1)\nR 8 (#27d840)\nD 7 (#069321)\nR 3 (#08be10)\nD 8 (#0cb9c3)\nR 7 (#372230)\nU 5 (#0cb9c1)\nL 4 (#3474a0)\nU 4 (#069323)\nR 4 (#1c9780)\nU 6 (#64e9b3)\nR 5 (#013fd0)\nU 3 (#4370b3)\nL 4 (#34d160)\nU 3 (#1aa763)\nR 6 (#42e460)\nU 7 (#3fe1a3)\nR 6 (#1aac50)\nU 3 (#564173)\nR 5 (#281990)\nU 3 (#50fd73)\nL 7 (#0fdfe0)\nU 3 (#1aa4a3)\nL 7 (#5db330)\nU 7 (#4a6163)\nL 3 (#6c2ee0)\nU 3 (#05d5b3)\nL 4 (#205c00)\nD 5 (#35a813)\nL 6 (#38a3a0)\nD 9 (#1d7ee3)\nL 9 (#38a3a2)\nU 7 (#247a93)\nL 4 (#2d4112)\nU 7 (#33c8e3)\nL 7 (#523732)\nU 8 (#2fc5e1)\nL 5 (#3d1042)\nD 8 (#2fc5e3)\nL 4 (#037172)\nD 6 (#144643)\nL 2 (#4bfe32)\nD 8 (#144641)\nL 4 (#3a6a12)\nD 4 (#3fafa3)\nR 6 (#186b62)\nD 6 (#161503)\nL 6 (#349a82)\nD 7 (#130743)\nL 3 (#302922)\nU 7 (#5eb933)\nL 4 (#16d232)\nD 4 (#38db13)\nL 7 (#0c7572)\nD 2 (#088f03)\nL 3 (#39d402)\nD 6 (#103c33)\nR 5 (#088bc2)\nD 5 (#4ca4f3)\nL 5 (#0a4d72)\nD 3 (#164d23)\nL 3 (#4ea5c2)\nU 4 (#3ed063)\nL 8 (#14f962)\nU 6 (#0d5d23)\nR 5 (#2b7da2)\nU 7 (#4cca33)\nL 5 (#1b1b92)\nU 3 (#689203)\nL 5 (#405a30)\nD 7 (#32c073)\nL 8 (#405a32)\nD 2 (#4e3c13)\nL 11 (#3d24a2)\nD 4 (#334ec3)\nL 2 (#1f55e2)\nD 5 (#5dca61)\nL 5 (#3d3622)\nU 6 (#5dca63)\nL 3 (#1d6682)\nD 6 (#08e9f3)\nL 5 (#14d5b2)\nD 5 (#08e9f1)\nL 3 (#6625a2)\nD 3 (#346e63)\nL 8 (#22b872)\nD 6 (#14c211)\nR 7 (#2219b0)\nD 7 (#394bf1)\nR 5 (#4d7d60)\nU 7 (#228751)\nR 6 (#2b6c50)\nD 5 (#30a991)\nR 7 (#45fac0)\nU 3 (#25b831)\nR 3 (#535960)\nU 8 (#48a8e1)\nR 7 (#2793a2)\nU 11 (#237a11)\nR 4 (#32c372)\nD 9 (#2a5653)\nR 4 (#070242)\nD 3 (#15b7f3)\nR 5 (#070240)\nD 10 (#37a9d3)\nR 6 (#1c2d42)\nU 10 (#23eb01)\nR 3 (#4c60a2)\nD 6 (#2678a1)\nR 4 (#4c60a0)\nD 4 (#2d5471)\nR 4 (#2cb782)\nD 3 (#3849f1)\nR 3 (#2fcd22)\nD 7 (#21e851)\nR 7 (#15e8b2)\nD 2 (#404ba1)\nR 3 (#15e8b0)\nD 8 (#186851)\nL 7 (#47f202)\nD 7 (#47a231)\nL 4 (#0e3cd2)\nD 4 (#2332c3)\nL 11 (#2e3422)\nD 6 (#0bad51)\nL 4 (#5af602)\nD 9 (#0bad53)\nL 4 (#21bba2)\nU 9 (#4a96a3)\nL 7 (#06dab2)\nU 4 (#67e973)\nL 10 (#011ed0)\nU 4 (#449971)\nL 7 (#5cc5c0)\nU 9 (#449973)\nL 9 (#53dbe0)\nU 4 (#484fa3)\nL 2 (#0b1fc2)\nU 5 (#41abb1)\nL 11 (#299252)\nU 4 (#310503)\nL 7 (#08f4f2)\nU 12 (#2f4c23)\nL 2 (#227db2)\nU 8 (#332e73)\nL 10 (#3b8d22)\nU 5 (#01dd73)\nL 5 (#1ce162)\nU 3 (#053f73)\nL 3 (#119a92)\nU 8 (#29f713)\nL 6 (#48ec42)\nD 8 (#363073)\nL 7 (#502b12)\nD 3 (#3ebd13)\nR 6 (#1c7512)\nD 6 (#27c1e3)\nR 10 (#187ac0)\nD 6 (#319253)\nR 5 (#1aac60)\nD 10 (#3e0a33)\nL 2 (#1adf30)\nD 5 (#147b71)\nL 3 (#555480)\nD 7 (#5b2111)\nL 7 (#00d2a0)\nU 7 (#10f163)\nL 9 (#273220)\nD 6 (#0d96c1)\nL 8 (#486b30)\nU 3 (#0d96c3)\nL 8 (#0b6cd0)\nU 7 (#10f161)\nL 6 (#2bd080)\nU 4 (#0d2f63)\nL 3 (#059010)\nU 7 (#1fa783)\nL 4 (#6de600)\nU 12 (#1fa781)\nL 7 (#05e470)\nU 3 (#2c9673)\nL 3 (#355ef0)\nU 6 (#0dddd3)\nR 9 (#423f90)\nU 3 (#1e9993)\nL 9 (#203672)\nU 7 (#617de3)\nR 8 (#363ae2)\nU 4 (#18e0d3)\nR 9 (#567150)\nU 8 (#0a1ec3)\nR 9 (#423f92)\nU 7 (#0c7353)\nL 12 (#1d13e0)\nU 6 (#34a503)\nR 12 (#36c650)\nU 4 (#503231)\nR 6 (#3fcd60)\nU 3 (#1178f1)\nR 6 (#4440a2)\nD 2 (#54b101)\nR 3 (#4440a0)\nD 11 (#3bb101)\nR 7 (#451730)\nD 11 (#2c9671)\nR 4 (#120090)\nD 4 (#1151a3)\nR 8 (#2b7da0)\nU 5 (#3639a3)\nL 4 (#3496a0)\nU 8 (#360c61)\nR 4 (#1135d0)\nU 7 (#1c2621)\nL 5 (#1532f0)\nU 8 (#29b063)\nL 8 (#6bcef0)\nU 7 (#29b061)\nL 2 (#0091b0)\nU 2 (#4b6031)\nL 9 (#255780)\nU 4 (#350441)\nL 5 (#154042)\nD 4 (#2fa351)\nL 9 (#06cc12)\nU 3 (#52a463)\nR 5 (#248972)\nU 7 (#3fbe03)\nR 5 (#21fe22)\nU 12 (#3fbe01)\nR 6 (#3c11c2)\nD 12 (#04d873)\nR 4 (#1f4f92)\nD 7 (#577cd1)\nR 6 (#09f782)\nU 7 (#1fb581)\nR 7 (#18e170)\nU 8 (#3883c1)\nR 5 (#0ec9a0)\nU 5 (#634a93)\nR 3 (#4a3e40)\nU 7 (#634a91)\nR 4 (#256ad0)\nU 4 (#2bd481)\nR 10 (#309890)\nU 5 (#1634b1)\nR 6 (#4e19d0)\nU 4 (#2f6a43)\nR 5 (#352aa2)\nD 9 (#4ae2e3)\nR 4 (#352aa0)\nD 3 (#073513)\nR 7 (#525d70)\nD 7 (#1929c3)\nR 10 (#3ae400)\nD 8 (#311ef3)\nR 3 (#078122)\nD 9 (#180443)\nL 4 (#042fc2)\nD 3 (#1a4371)\nL 5 (#266852)\nU 5 (#178891)\nL 8 (#4b05f2)\nD 5 (#178893)\nL 3 (#0cc4f2)\nD 4 (#1a4373)\nR 6 (#104642)\nD 4 (#362783)\nR 9 (#206000)\nD 3 (#6ea953)\nR 5 (#2bd220)\nD 8 (#060073)\nR 8 (#1b5420)\nD 4 (#279771)\nR 4 (#2d7662)\nD 9 (#46f751)\nR 7 (#2d7660)\nD 10 (#061b01)\nR 3 (#32a410)\nU 12 (#28ef03)\nR 3 (#1063a0)\nU 6 (#152583)\nL 4 (#571f30)\nU 6 (#0b19b3)\nR 4 (#0e4fe0)\nU 4 (#4fbf11)\nR 7 (#0379f0)\nU 4 (#4874e1)\nR 3 (#630bc2)\nD 8 (#0a46c1)\nR 5 (#0b7cd2)\nD 4 (#5c2dc1)\nR 3 (#15c350)\nU 12 (#31b781)\nR 5 (#58c540)\nU 6 (#2d39d1)\nR 7 (#0379f2)\nD 2 (#058b11)\nR 6 (#31ce00)\nD 5 (#1cd3b1)\nR 9 (#5087e0)\nU 5 (#3ee9d1)\nR 3 (#5087e2)\nD 9 (#257411)\nR 3 (#48a7b2)\nU 7 (#3ed791)\nR 8 (#614372)\nU 6 (#4fbf11)\nL 4 (#59f212)\nU 5 (#4fbf13)\nL 7 (#36c9d2)\nD 5 (#06dc01)\nL 6 (#4854f2)\nU 9 (#2c8471)\nR 4 (#1ceb70)\nU 7 (#4953b1)\nR 6 (#1bf890)\nD 7 (#60a641)\nR 7 (#1bf892)\nU 3 (#114ff1)\nR 4 (#2ac060)\nD 6 (#0dae41)\nR 6 (#5361f0)\nD 4 (#00f171)\nL 6 (#524080)\nD 4 (#2b4ec3)\nR 5 (#1dba40)\nD 7 (#2b4ec1)\nR 6 (#3f2d70)\nD 4 (#595893)\nR 3 (#2c3260)\nU 11 (#3aa063)\nR 8 (#36fa30)\nU 7 (#48eea3)\nL 9 (#39e1d0)\nU 5 (#0afa71)\nL 3 (#2657f0)\nU 10 (#3c6601)\nL 6 (#1e8fa0)\nU 8 (#3c2e91)\nL 4 (#40bad0)\nU 2 (#0f50d1)\nL 6 (#6184d0)\nU 2 (#4e1ac1)\nL 4 (#44e180)\nD 4 (#154dc3)\nL 5 (#2fb800)\nD 7 (#257ce1)\nL 5 (#2892f0)\nD 5 (#257ce3)\nL 9 (#1dc870)\nU 6 (#481dd3)\nL 7 (#157020)\nU 6 (#595891)\nL 6 (#22f720)\nD 13 (#4fa6e3)\nL 2 (#1ebab0)\nU 13 (#4f5361)\nL 7 (#3d92d0)\nU 4 (#4f5363)\nL 5 (#254680)\nU 9 (#203463)\nR 9 (#4bc310)\nU 2 (#4ac9a3)\nR 4 (#0eb840)\nU 12 (#238933)\nR 6 (#5983c0)\nD 11 (#3bad63)\nR 5 (#0a9a90)\nD 3 (#5f3691)\nR 10 (#1a75b0)\nU 2 (#353433)\nR 10 (#4d7910)\nU 5 (#0f8c63)\nR 4 (#0f01a0)\nU 5 (#41d983)\nR 12 (#567c70)\nU 7 (#235bf3)\nL 6 (#3d3260)\nU 7 (#3670c3)\nR 8 (#0ae380)\nU 11 (#39f0f3)\nL 8 (#5a3b50)\nU 7 (#3ef7f3)\nR 6 (#1f8b10)\nU 9 (#0af2c3)\nR 7 (#352e02)\nU 4 (#4ac4f3)\nL 4 (#4f7be2)\nU 8 (#5290f3)\nR 4 (#5dfcb0)\nU 5 (#52a673)\nR 5 (#209ad0)\nD 5 (#4aec43)\nR 4 (#10d190)\nU 7 (#10af81)\nR 3 (#466070)\nU 7 (#40f621)\nR 5 (#466072)\nU 6 (#393501)\nR 5 (#208170)\nU 5 (#5f05d1)\nR 3 (#3543d0)\nD 8 (#4838b3)\nR 4 (#0578c0)\nD 7 (#700eb3)\nL 4 (#3ee0f0)\nD 3 (#362cd1)\nR 3 (#5b4aa0)\nD 7 (#3acda1)\nR 9 (#5b4aa2)\nD 10 (#404441)\nR 10 (#2587c0)\nD 8 (#0708b1)\nR 7 (#208490)\nD 3 (#1c1d31)\nR 5 (#125af2)\nU 12 (#35d991)\nR 4 (#34d352)\nD 12 (#33bc31)\nR 6 (#154a20)\nD 6 (#47f8b1)\nR 5 (#154a22)\nU 6 (#04ad41)\nR 11 (#293322)\nU 8 (#1f1b33)\nR 10 (#25e712)\nU 3 (#243993)\nR 4 (#25e710)\nU 2 (#3d0d63)\nR 5 (#358112)\nU 8 (#1c2051)\nR 5 (#3a48d2)\nU 5 (#365811)\nR 5 (#0c80c0)\nD 10 (#1acc61)\nR 4 (#54dcc0)\nD 3 (#350a11)\nR 8 (#219790)\nD 10 (#49ee81)\nR 6 (#3ab6e0)\nD 7 (#34ec81)\nR 5 (#6ec4d0)\nD 3 (#102551)\nR 9 (#020e20)\nD 2 (#3dd911)\nR 5 (#55d840)\nD 3 (#2e4331)\nR 5 (#254262)\nD 9 (#54ac01)\nR 10 (#576822)\nD 5 (#2b7e21)\nL 12 (#6d7532)\nD 3 (#3bbd91)\nL 3 (#085512)\nD 5 (#1801d1)\nR 6 (#495022)\nD 6 (#48c991)\nL 12 (#2c6252)\nD 3 (#60cb63)\nL 6 (#3a6cf2)\nD 3 (#160ad3)\nL 6 (#3a53d2)\nD 11 (#184dd3)\nL 3 (#2551e2)\nD 3 (#184dd1)\nL 11 (#4d0072)\nD 6 (#160ad1)\nL 4 (#445b42)\nD 6 (#52c611)\nR 6 (#337af2)\nD 2 (#28d391)\nR 8 (#1e6790)\nD 10 (#1e46d1)\nL 10 (#422400)\nD 3 (#64ab01)\nR 4 (#1607d0)\nD 6 (#04f111)\nR 7 (#138d50)\nU 6 (#252281)\nR 9 (#3b06a2)\nD 6 (#3c3901)\nR 4 (#30b282)\nD 4 (#4568e1)\nL 8 (#385bc0)\nD 7 (#157261)\nL 4 (#4e9b22)\nD 8 (#689a31)\nL 12 (#4e9b20)\nD 3 (#290681)\nR 10 (#06ddf0)\nD 8 (#132223)\nR 9 (#686f60)\nD 7 (#4048d3)\nR 4 (#342060)\nD 3 (#204d51)\nR 5 (#07e040)\nD 4 (#204d53)\nL 6 (#3a7bb0)\nD 6 (#37d083)\nL 10 (#1f3d80)\nD 3 (#1d8fd3)\nL 5 (#16b082)\nD 9 (#119673)\nL 11 (#1d1772)\nD 3 (#2a2723)\nR 12 (#2b9662)\nD 8 (#2a2721)\nR 6 (#302fa2)\nU 8 (#43b103)\nR 11 (#0a3500)\nD 5 (#354b03)\nR 13 (#5eaea0)\nD 4 (#354b01)\nL 3 (#0ff9d0)\nD 7 (#327d63)\nL 3 (#16b080)\nD 3 (#05de43)\nL 3 (#381a00)\nD 5 (#4040e3)\nR 11 (#1a01b2)\nD 6 (#072c11)\nL 11 (#5c23c2)\nD 3 (#072c13)\nL 2 (#25cd12)\nD 5 (#362963)\nL 7 (#122ae0)\nU 8 (#2f98e3)\nL 3 (#4ac460)\nU 8 (#2f98e1)\nL 2 (#3f0340)\nU 6 (#28e1c3)\nL 6 (#490c50)\nU 5 (#2cace1)\nL 6 (#2ea3d0)\nD 4 (#3d8f31)\nL 6 (#45cf70)\nU 4 (#21dc11)\nL 5 (#32f7f2)\nU 5 (#0ad623)\nL 4 (#0e0272)\nU 6 (#0ad621)\nL 8 (#3378e2)\nD 7 (#12c121)\nL 11 (#1805f0)\nD 4 (#0edd81)\nL 11 (#61ecf0)\nU 7 (#1355b1)\nL 3 (#104e80)\nU 7 (#3c6bf1)\nL 4 (#084972)\nU 11 (#15dd41)\nR 5 (#685922)\nU 3 (#3b0f11)\nL 6 (#0ec442)\nU 7 (#36c961)\nR 6 (#6f14b0)\nU 5 (#3298b1)\nR 8 (#105220)\nU 3 (#310571)\nR 4 (#2b1702)\nU 9 (#260fa3)\nR 8 (#455922)\nU 3 (#260fa1)\nR 3 (#19d142)\nU 8 (#17ea11)\nR 6 (#38ecd2)\nU 5 (#1a1931)\nL 5 (#464de2)\nU 3 (#4c3b91)\nL 4 (#1b16c2)\nU 9 (#6654c3)\nL 8 (#1e7dd2)\nU 5 (#2a1f91)\nL 3 (#2a7b62)\nU 4 (#26c251)\nL 4 (#250742)\nU 5 (#275c11)\nL 10 (#13c962)\nU 5 (#275c13)\nL 4 (#37b4a2)\nU 3 (#3be851)\nL 5 (#0401a0)\nU 9 (#29b7e1)\nL 3 (#044032)\nU 5 (#12e441)\nL 13 (#380b60)\nU 3 (#38e951)\nL 3 (#28c040)\nU 4 (#2b40e1)\nL 8 (#60cba2)\nU 7 (#059311)\nL 6 (#044030)\nU 11 (#2c1a41)\nL 4 (#0401a2)\nD 7 (#0d1291)\nL 5 (#11c4a2)\nU 10 (#0d1e61)\nL 4 (#28e382)\nD 10 (#32d681)\nL 5 (#4a6022)\nD 5 (#31a741)\nR 11 (#22f822)\nD 4 (#647dc3)\nR 3 (#294f62)\nD 4 (#18f561)\nR 4 (#3762b2)\nD 5 (#4ebb03)\nL 6 (#4c2a52)\nD 9 (#4ebb01)\nR 6 (#5c0d82)\nD 5 (#18f563)\nL 4 (#16a472)\nD 3 (#0e1271)\nR 13 (#000c12)\nD 6 (#465a51)\nL 13 (#0bf4b2)\nD 6 (#0ffe93)\nL 2 (#3b2c42)\nD 4 (#0ffe91)\nR 9 (#303472)\nD 5 (#465a53)\nR 6 (#00a1d2)\nD 5 (#3f5ec1)\nR 12 (#11b762)\nD 5 (#1fec81)\nR 8 (#04d602)\nD 2 (#346b31)\nR 3 (#6da912)\nU 5 (#2afbc1)\nR 5 (#45c912)\nD 5 (#1b0d61)\nR 6 (#3915f2)\nD 5 (#1b0d63)\nL 5 (#23bef2)\nD 13 (#06d751)\nL 5 (#671192)\nU 5 (#3a9191)\nL 7 (#171f52)\nU 5 (#582ea1)\nL 4 (#5084e2)\nU 7 (#1bc721)\nL 6 (#46b262)\nD 4 (#3b23b3)\nL 4 (#565362)\nD 5 (#2c5f73)\nL 5 (#2c14a2)\nD 8 (#240191)\nL 5 (#638662)\nD 7 (#438191)\nL 8 (#121f12)\nD 6 (#088063)\nL 5 (#2b2ed2)\nD 9 (#340df3)\nL 11 (#30dc52)\nD 6 (#32cbf3)\nL 10 (#451942)\nD 8 (#1cf853)\nL 10 (#4f1e12)\nD 3 (#32afd3)\nL 4 (#4f1e10)\nD 4 (#43d723)\nR 12 (#209752)\nD 6 (#4b2143)\nL 12 (#65b090)\nD 4 (#29ebd3)\nL 4 (#02cb22)\nU 9 (#380263)\nL 5 (#643ff2)\nU 6 (#4844d3)\nL 7 (#376762)\nU 5 (#11c443)\nL 2 (#487de2)\nU 7 (#6e1383)\nL 7 (#184542)\nU 7 (#12f1d3)"

case class DigPlan(direction: String, length: Long)

def parse(input: String): List[DigPlan] =
  input.linesIterator.map( line =>
    val (s"$direction $length (#$hexCode)") = line: @unchecked
    DigPlan(direction = direction, length = length.toLong)
  ).toList

def parseHex(input: String): List[DigPlan] =
  input.linesIterator.map( line =>
    val (s"$a $b (#$hexCode)") = line: @unchecked

    val direction = hexCode.drop(5) match
      case "0" => "R"
      case "1" => "D"
      case "2" => "L"
      case "3" => "U"

    val length = Integer.parseInt(hexCode.dropRight(1), 16)

    DigPlan(direction = direction, length = length)
  ).toList

def calcPerimeterLength(digPlans: List[DigPlan]): Long =
  digPlans.map(_.length).sum

def getVertices(digPlans: List[DigPlan]): List[(Long,Long)] =
  // iterate through each of the dig plans
  // add the coordinates to a list
  var x = 0L
  var y = 0L

  val vertices = digPlans.map(digPlan =>
    if digPlan.direction == "R" then x += digPlan.length
    if digPlan.direction == "L" then x -= digPlan.length
    if digPlan.direction == "U" then y -= digPlan.length
    if digPlan.direction == "D" then y += digPlan.length

    (x, y)
  )
  vertices

def calcShoelaceArea(vertices: List[(Long,Long)]): Long =
  val numberOfVertices = vertices.size
  var sum1 = 0L
  var sum2 = 0L

  for (i <- 0 until numberOfVertices-1) {
    sum1 = sum1 + vertices(i)(0) * vertices(i + 1)(1)
    sum2 = sum2 + vertices(i)(1) * vertices(i + 1)(0)
  }

  // Add xn.y1
  sum1 = sum1 + vertices(numberOfVertices - 1)(0) * vertices(0)(1)
  // Add x1.yn
  sum2 = sum2 + vertices(0)(0) * vertices(numberOfVertices - 1)(1)

  val area = (sum1 - sum2).abs / 2
  area

def calcPolygonBoundaries(perimeterBlocks: Long): Long =
  val outerCorners = 4  // as its a right angled polygon which will give 4 edge corners exposing an extra boundary wall each
  perimeterBlocks + outerCorners

def picksTheoremArea(interior: Long, boundary: Long): Long =
  interior + (boundary/2) - 1

def calculateArea(digPlans: List[DigPlan]): Long =
  // apply shoelace theorem to get the interior area
  // then combine with picks theorem to get overall area
  // to calculate the boundaries, its the perimeter length plus 4 additional boundaries due to edge corners of right angled polygon
  val perimeterBlocks = calcPerimeterLength(digPlans)
  val boundaries = calcPolygonBoundaries(perimeterBlocks)
  val vertices = getVertices(digPlans)
  val shoelaceArea = calcShoelaceArea(vertices)

  picksTheoremArea(shoelaceArea, boundaries)

def partOne(input: String): Long =
  val digPlans = parse(input)
  calculateArea(digPlans)

def partTwo(input: String): Long =
  val digPlans = parseHex(input)
  calculateArea(digPlans)


var startTime = System.currentTimeMillis()
partOne(sampleInput)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partOne(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Puzzle Input Time Taken: $timeTaken ms")


startTime = System.currentTimeMillis()
partTwo(sampleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partTwo(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Puzzle Input Time Taken $timeTaken ms")
