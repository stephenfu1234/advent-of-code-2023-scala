import scala.collection.mutable

val sampleInput = "#.##..##.\n..#.##.#.\n##......#\n##......#\n..#.##.#.\n..##..##.\n#.#.##.#.\n\n#...##..#\n#....#..#\n..##..###\n#####.##.\n#####.##.\n..##..###\n#....#..#"

//val sampleInput = "#...##.\n####..#\n....##.\n..#.##.\n#.##..#\n.##....\n...#..#\n..###.#\n#..####\n#...##.\n#...##."
// puzzle pattern 3

val puzzleInput = "...#..##.####.#\n##..##.###..###\n#.#............\n#...#...#..#.#.\n.#..###.#.##.#.\n###.###.##..##.\n.....##........\n##..#....#..#..\n#....#...#..#..\n#..##.#.#.##.#.\n#..##.#.#.##.#.\n#....#...#..#..\n##..#....#..#..\n.....##........\n###.###.##..##.\n\n...#.#.####.#.#\n#..#..##.###..#\n..#.##..##..##.\n##...########..\n.####..####..##\n.##............\n#...#.#.##.#.#.\n.#..#.#.##.#.#.\n.#.##..####..##\n##..####..####.\n##..####..####.\n.#.##..####..##\n.#..#.#.##.#.#.\n#...#.#.##.#.#.\n.##............\n\n#...##.\n####..#\n....##.\n..#.##.\n#.##..#\n.##....\n...#..#\n..###.#\n#..####\n#...##.\n#...##.\n\n.#.#.########\n..#..####..##\n#.#..####..##\n.#.#.########\n...##.#.####.\n.##.##...##..\n.#####.#....#\n....#.#.#..#.\n#..##..##..##\n#...####....#\n###...###..##\n#.##....####.\n#..#.#.......\n##.##..#.##.#\n##.###.......\n\n.#...##\n#..####\n.##....\n..#....\n..#.#..\n#.#.#..\n..#....\n.##....\n#..####\n.#...##\n#..#.##\n#..#...\n..#.###\n..#####\n.###...\n\n.####.##......#\n...##.##..##..#\n...##.##..##..#\n.####.##......#\n#.##.#..#.##.#.\n..#####.##.###.\n.#...#...#..#..\n#######.######.\n.#.#...########\n\n..#..#.##\n##.#####.\n.##.#..##\n...#.##..\n..#...##.\n....##..#\n####.##..\n####.##..\n....##..#\n..#...##.\n...#.##..\n\n#....#.#.#....#.#\n#....###.#....#.#\n.##.#....#.##.#..\n.###.###.#....#.#\n.##.....##....##.\n###.#.#..#.##.#..\n##...#.#.######.#\n##..##.####..####\n#.#..###..#..#..#\n.#####..#.#..#.#.\n.#.##.#..#.##.#..\n\n.##.##.##\n#..####.#\n#..####.#\n.##.##.##\n##.##.###\n.##..###.\n#..#.#...\n\n#...#..#.\n#...#..#.\n.####..#.\n..#..#..#\n...#....#\n##..###..\n#...####.\n#...####.\n##..##...\n...#....#\n..#..#..#\n.####..#.\n#...#..#.\n\n#.##.#..#.##.\n......##.....\n..#.#.##.#.#.\n###.#....#.##\n..#...##...#.\n......##.....\n###.#....#.##\n\n...#..#.....##.##\n...#........##.##\n......###........\n..##....#...#####\n##..###.######.#.\n#.....#..##.###.#\n#.#######.#...##.\n#.###..#.##.##.#.\n..##..#..##.####.\n.#.#..###...##.##\n###..##.###..##.#\n#.##.##.##..##..#\n#.##.##.##..##..#\n\n#..#....#\n#..#....#\n#....##..\n.###..#.#\n.#.##...#\n..#....##\n..#....##\n.#.##...#\n.###..#..\n\n...###...##\n##....#..#.\n###.#.#....\n#..###.##.#\n#..###.##.#\n###.#......\n##....#..#.\n...###...##\n...###...##\n##....#..#.\n###.#......\n\n..#.#.###...##...\n##.#...##.######.\n##.#...##.######.\n#.#.#.###...##...\n.#...#..##.####.#\n.###..#.####..###\n#.##.#.#.#.#..#.#\n\n#..#.#..#......\n.####.....####.\n.#.#####.......\n#.#.#####.####.\n##..#...##.##.#\n...####...####.\n.####.#########\n....#..########\n...#.##...####.\n...#.##...####.\n....#..########\n.###..#########\n...####...####.\n\n##.###.#.\n#.#..#.#.\n...#.#.##\n...#.#.##\n#.#..#.#.\n##.###.#.\n..#....#.\n#..#.####\n..###.#.#\n#####..#.\n..#.####.\n...###.#.\n...###.#.\n..#.####.\n#####..#.\n..###.#.#\n#....####\n\n##..#..#..#\n#...#....#.\n#.......##.\n#.#...##..#\n.#..#...##.\n.##########\n.#....##..#\n.##.###....\n#.###..#..#\n#.###..#..#\n.##.###....\n\n#.#.#.#.##.#.\n.##.###.##.##\n..#...#...##.\n##.#....##...\n##...###..###\n#.##....##...\n#.##....##...\n\n#.####.##..##..\n#.###..##..##..\n#.###..####.###\n.#..#.#...###..\n...##..#..##...\n##..#.#..#.#.##\n.....#.##..#..#\n.##....#.####.#\n###.##.########\n#.....#..#...##\n...##...#####.#\n##....#..##....\n##....#..##....\n...##...#####.#\n#.....#..#...##\n\n##..####..####.\n##...##...####.\n#.##.##.##.##.#\n###.####.######\n.####..####..##\n.#.#...##.#..#.\n#..........##..\n....#..#.......\n.##.#..#.##..##\n#####..########\n...#....#......\n\n###.#.#..#.\n#..##.#####\n.##.###..##\n..#.#.####.\n.#.#...##..\n##...######\n.#.....##..\n.#.....##..\n##...######\n\n..#....#.....\n##########..#\n#........#..#\n..........##.\n#.#....#.####\n#....#...####\n.#.####.#.##.\n#.##..##.####\n..........##.\n\n.#...#..#..\n#..#....#..\n#..#...##..\n##.#..#..##\n.###...####\n#.#.#...#..\n.###.#.#...\n###.#####..\n#..........\n.#....#....\n.#....#.#..\n\n#...##.#...#.##\n##...#.###..###\n#....##..#.###.\n.###..#.##.....\n##.#..##.#.#.#.\n####.#...#.#...\n.#.....#..#...#\n.#.....#..#...#\n####.#...#.#...\n##.#..##.#.#.#.\n.###..#.##....#\n#....##..#.###.\n##...#.###..###\n#...##.#...#.##\n##..#...#.#.#.#\n#...#.##.##....\n#...#.##.##....\n\n#.#..####..#.##.#\n..###....###....#\n.##.#.##.#.##..##\n...########......\n.###.####.###..##\n.###..##..###..##\n###..#..#..######\n...##.##.##......\n.#..##..##..#..#.\n##...####...####.\n..#.#.##.#.#....#\n##..........####.\n..#.######.#....#\n..#.#.####.#....#\n#.#..#..#..#.##.#\n####.#..#.#######\n.#...####...#..#.\n\n..#.##.#...#..#\n.#..##..#.#..#.\n#..####..##.##.\n.#.#..#.#.##...\n###########....\n#.#....#.#..#..\n.###..###.#...#\n##.####.###..#.\n.#..##..#...##.\n#.######.#.#..#\n##..###.####...\n#........##.#.#\n.########.#....\n.########.#....\n#........##.#.#\n\n###...##...##\n#.#.##..##.#.\n#.#.##..##.#.\n###...##...##\n#....####....\n##.##.##.##.#\n.##........##\n.#.#.#..#.#.#\n##..#....#..#\n#..##.##.##.#\n.#.###..###.#\n.##........##\n..#...##...#.\n\n#..#....#..##\n.##.#..#.##..\n...#.##.#....\n##...##...###\n.#..#..#..#..\n#..##..##..##\n.##......##..\n....####...##\n...#.##.#....\n.##..##..##..\n.###.##.###..\n#....##....##\n####....#####\n#.#.####.#.##\n###......####\n....#..#.....\n#.#.#..#.#.##\n\n##.###..#....#..#\n..###..#.###.....\n##.#####...####..\n#...#.#.###..#.##\n#...###.###..#.##\n##.#####...####..\n..###..#.###.....\n##.###..#....#..#\n#.#....##...#####\n#.#....##...#####\n##.###..#....#..#\n\n#..#..#..#..#..\n####..#########\n.##..#.#......#\n#.#..#.#.####.#\n..#...#########\n#..####..#..#..\n..#..##.##..##.\n##...##.#....#.\n##.#.##.#....#.\n\n.#.##.##.#.##..\n###.##.####..#.\n.#.#.#..####.##\n.#.#.#..####.##\n###.##.####..#.\n.#.##.##.#.##..\n...##.###.###.#\n.##....#.###.##\n#..#.#.##.#..#.\n.###.######....\n####...##.#....\n####...##.#.#..\n.###.######....\n\n..##.#.##\n##.#.#.##\n###......\n#..#.##..\n.#..##.##\n..###.#..\n#....#.##\n#..##..##\n##.#..#..\n..#.###..\n..#.##...\n##.#..#..\n#..##..##\n#....#.##\n..###.#..\n\n..#..#.##.#\n.......##..\n####.......\n.#...##..##\n#.#########\n..##.##..##\n#.###......\n\n....####.#.#.##\n.##...##...#.##\n####...###.##..\n#..###....#..#.\n#..###....#..#.\n####...###.#...\n.##...##...#.##\n\n##....#...#\n######..##.\n##.#####.#.\n.......#.#.\n..##......#\n..#........\n####.##.##.\n.....#..###\n...#####.##\n...###.#.##\n.....#..###\n\n##...#.###.\n###.####.#.\n###.#.....#\n...###.#.#.\n...#######.\n##.....###.\n##..##.####\n..####.#...\n#####..#.##\n##.....##.#\n....##..#..\n###..###.#.\n###...##.#.\n\n#...####.##.###\n.#####.#...####\n#.#.#..#.#..##.\n#.#.#..#.#..##.\n.#####.#...####\n....####.##.###\n###..###.###.#.\n..##...#.#..#.#\n#.#.#...###.###\n.###..#...##..#\n######.......#.\n#...#####..##.#\n#...#####..##.#\n######.......#.\n.###..#...##..#\n\n###.#.####.#.\n.#####.##.##.\n#.#..#.###.#.\n#..####.#...#\n#..####.#...#\n#.#..#.###.#.\n.#####.##.##.\n###.#.####.#.\n.##..#.#.#..#\n.##..#.#.#..#\n###.#.####.##\n.#####.##.##.\n#.#..#.###.#.\n\n#.####.####..#.##\n.##..##..#.##.#..\n.........######..\n.##..##.#.####.#.\n#..##..#.#....#.#\n##.##.####....###\n.#.##.#.##....##.\n..####.....##....\n#.#..#.###.##.###\n#......##########\n#......#...##...#\n\n.#..#####.#\n.#.#....#.#\n......##.##\n#.....##.##\n.#.#....#.#\n###.#......\n###.#......\n.#.#....#.#\n#.....##.##\n......##.##\n.#.#....#.#\n\n#.##..##.#...##.#\n#..#..#..##.##.##\n##......##..##..#\n#.##..##.#..#.###\n#.##..##.#..#.###\n##......##..##..#\n#..#..#..##.##.##\n#.##..##.#....#.#\n.###..###..###...\n##.####.##..###.#\n#.#....#.###.###.\n.#......#.#.##...\n##..##..##.###.#.\n\n####...##..#.\n##.#..#......\n##.#.####.###\n...........#.\n.##.##.#####.\n..###..#.#...\n..#..#.##....\n###..##....##\n..##..#.#.###\n..#..#.##.#.#\n..#..#.##.#.#\n\n##.######\n..#.#..#.\n..#..##..\n.#.#.##.#\n##...##..\n..#......\n.##......\n\n#..#.#.#.##\n....#.#..#.\n#..##.#..#.\n#..##.#.##.\n#..##..###.\n#..#..###..\n.##.##..#.#\n.##.##.##.#\n#..#..###..\n\n.#.#..#....\n.#.#..##...\n.#.##...#..\n#...#.#..##\n#...##.####\n..##....###\n#...####.##\n\n####.####.#.###\n####.####.#.###\n..#...#####.##.\n#.#.#...#..#...\n#.###.#.#..#...\n.....##.#######\n.#..###...###.#\n...###.##...#..\n...#.#.##...#..\n\n.....#..###..#.\n##...#...##.##.\n###..#..####...\n##..##....##.##\n##.#..########.\n###...#..#####.\n..##.#..#.#....\n##..####...###.\n###..#...#....#\n####.##.#..##..\n####.####..##..\n###..#...#....#\n##..####...###.\n\n.#.#.##.###.#..\n#..###.....####\n.....##.##.....\n#.#..#...##.#..\n#..####...###..\n..######.#.#...\n.##.#.#..##.#..\n.#...##.#...###\n.#...##.#...###\n.##.#.#..##.#..\n..######.#.#...\n#..####...###..\n#.##.#...##.#..\n\n##..##.\n.....##\n##..##.\n..##...\n##..##.\n.####..\n......#\n##..###\n.####.#\n#....##\n######.\n......#\n#.##.##\n#.##.#.\n#.##.#.\n\n.#.##.#.#.##.##\n##....###..##..\n#.#..#.#..####.\n.######....##..\n#.####.###.##..\n#.####.###.##..\n.######....##..\n#.#..#.#..####.\n##....###..##..\n.#.##.#.#.##.##\n........####...\n#..##..#....#.#\n#......#.##.#..\n##....###.####.\n.#.#..#..#.##..\n\n#..........#.\n.##...##...##\n#.#...##...#.\n...#.#..#.#..\n...###..###..\n.....#..#....\n..##.#..#.##.\n.#..######..#\n.#..######..#\n\n..#..###.....\n..##.###.....\n.....##.#.##.\n.####..#.##..\n.##.#..##...#\n#.#.#...#...#\n......###.##.\n.####..#####.\n#..#.##..#.##\n#..#.##..#.##\n.####..#####.\n......###.##.\n#.#.#...#...#\n\n.#.###.##\n..#.#####\n#.####.##\n#.#.#.##.\n...#..#..\n#..##..##\n##...#.##\n.#...##..\n.#..#..##\n.#..#..##\n.#...##..\n##...#.##\n#..##..##\n\n.#..####...#....#\n.......##...##.##\n.......##...##.##\n.#..####...#....#\n.#.###.###..##..#\n.##.###..........\n#####.#.#.##.###.\n.#.###.#######...\n...##..##.#.##..#\n.###.#.####.#...#\n.###.#.####.#.#.#\n\n.#..#..#..#..#.\n####....#######\n#####..########\n...#....#......\n..##.##.##....#\n#..#....#..##..\n...######......\n.###....###...#\n.#..####..#..#.\n\n..##......#.#\n###.###..#..#\n######.#.#..#\n######..##.##\n#....#..##.#.\n.####.#....#.\n..##..####..#\n##..####.##..\n##..####.##..\n\n..#.##..##.\n....#....#.\n.##..#..#..\n#..#..##..#\n.##..####..\n.##..#..#..\n#..###..###\n.##.#.##.#.\n#..##....##\n\n##.##.###\n#.####.##\n...##....\n.##..##..\n...##....\n#.####.##\n#..##..##\n##....###\n#..##..##\n...##....\n#.####.##\n##....###\n.##.###..\n#.####.##\n#..##..##\n#......##\n..#..#...\n\n.####.###..#.\n#....#...#.##\n#....###.##.#\n......#####..\n......#.###.#\n.#..#..#.##..\n..##..##.##.#\n......##.#.#.\n..#......##.#\n######...####\n.........####\n#.##.#.##.#..\n#.##.#.##.#..\n.........####\n######...####\n\n..##.###.#.\n###.###.##.\n.#.##.##...\n.#.##.##...\n###.###.##.\n..##.###.#.\n###..##...#\n...#.###.#.\n#.##.##..#.\n..#.....#..\n##.....####\n.#.###..###\n####..#..##\n####..#..##\n.#.###..##.\n\n##..#..#....#\n#.###.#.###..\n#.#..#.#...#.\n####.#..###..\n.#..##.#.#..#\n.#....#######\n..#.####.##.#\n..#.####.##.#\n.#....#######\n.#..##.#.#..#\n####.#..###..\n#.#..#.#...#.\n#.##..#.###..\n##..#..#....#\n##..#..#....#\n\n##..#.##.##\n##.##.#.#..\n#.#.#######\n.##....#.#.\n#.###..##.#\n#.###..##.#\n.##....#.#.\n#.#.#######\n##.##.#.#..\n##..#.##..#\n..#..###.#.\n#.##.#.#.##\n#.##.#.#.##\n..#..###.#.\n##..#.##..#\n\n#.#............\n...##.##..##..#\n.#..###.##.###.\n####.#.#..#.#.#\n..#.##......##.\n#..#.#......#.#\n..##.#......#.#\n.#.#....##....#\n#####........##\n#..#..##..##..#\n#..#..##..##..#\n#####........##\n.#.#....##....#\n..##.#......#.#\n#..#.#......#.#\n\n##.##.#.##.#..#\n.##.#.#.#.###.#\n....#.#......##\n....#.#......##\n.##.#.#.#.###.#\n##.##.#.##.#..#\n#..##..#....#.#\n.###.#####...#.\n.###.#####...#.\n...##..#....#.#\n##.##.#.##.#..#\n\n#.##.###.\n.##.##...\n.##.##...\n#.##.###.\n....#.###\n##..#..##\n..##.#.#.\n...#.##.#\n..#######\n..######.\n...#.##.#\n\n.#.#.####.....#\n#....#....#.#.#\n.#####.#.#..#.#\n...#..###...###\n..##...#.######\n###.#####..####\n....#....####.#\n....#....####.#\n###.#####..####\n..##...#.######\n...#..###...###\n.#####.#.#..#.#\n#....#....#.#.#\n.#.#.####.....#\n..##....#....##\n##..#..#...###.\n##..#..#...#.#.\n\n##.########\n##.########\n####.#..#.#\n.#..##.###.\n.##.######.\n#..#......#\n.#####..###\n.###......#\n.#.#.####.#\n.....####..\n.....#..#..\n##..#.##.#.\n.#...####..\n\n.....###.\n...#.##..\n.....###.\n.....###.\n...#.##..\n.....###.\n####.....\n#...###.#\n#...###.#\n####..#..\n.....###.\n\n##....###\n.#....#..\n#..##..#.\n##.##.#.#\n#.#..#.#.\n.##..##..\n#..##..#.\n.######.#\n##.##.##.\n..#..#..#\n##....###\n##....##.\n#.####.#.\n#.####.#.\n#.####.#.\n\n.##..#.##.#..\n#.###.#..#.##\n......####...\n#......##....\n.#.#.#....#..\n..#.#.####.#.\n####..####..#\n#.#..#....#..\n..#...####...\n..#...####...\n#.#..#....#..\n####..####..#\n..#.#.####.#.\n\n.##.#..#..##.##.#\n.###.#...###.##.#\n.###...#.....##..\n.###..##.....##..\n.###.#...###.##.#\n.##.#..#..##.##.#\n..####....#......\n###...##..#..##..\n#...#...####.##.#\n.####.#.###..##..\n##.#####..###..##\n\n###.#.##.....\n.##...##..###\n.##...##..###\n###.#.##.....\n.....###.##..\n##...###.#...\n#####.#......\n.##.#..##.##.\n.##.#..##.##.\n#####.#..#...\n##...###.#...\n.....###.##..\n###.#.##.....\n\n...##.##.#.\n####..##...\n.##.##..#..\n.##...#.#.#\n#..#.#...#.\n##.#.#.#...\n#.......##.\n#........#.\n##.#.#.#...\n####.##...#\n#.##.#.##..\n#.##.#.##..\n####.##...#\n##.#.#.#...\n#........#.\n#.......##.\n##.#.#.#...\n\n#.##.#.#.##.#.#.#\n.......##..##....\n########.##.#####\n.#..#.##....##.#.\n.####..##..##..##\n#######......####\n......########...\n#.##.#.#.##.###.#\n........#..#.....\n..##..#.#..#.#..#\n.####..######..##\n#.##.###....###.#\n.#..#..........#.\n..##...#.##.#...#\n......#......#...\n\n####..#..######\n#.#.#.##.##.##.\n...###.#.#.....\n...###.#.#.....\n#.#.#.#####.##.\n####..#..######\n.##.#...##.#.##\n..###.####.##..\n#...##...#..#.#\n.#.#..#.#######\n......##.###..#\n####...#.#####.\n....###.#..#...\n..####.########\n..####.########\n\n.#####.#..#.###\n..#.....##.....\n######.####.###\n##.##..####..##\n##.##..####..##\n######.####.###\n..#.....##.....\n.#####.#..#.###\n.##############\n.#..#...##...#.\n...###.#.##.###\n.##.#.#....#.#.\n#####...##...##\n\n#...#..####\n#.#.#...##.\n..##.###..#\n#.#..#.####\n##.#.#..##.\n##.#.#..##.\n#.#..######\n..##.###..#\n#.#.#...##.\n\n######.##.##.\n...##.....##.\n##....##.##..\n.######.#..#.\n#.#..#.#.##..\n.######.#.#..\n#......##.###\n###..###.....\n###..###.....\n\n#.#########\n####..##..#\n.##########\n#..###..###\n..##..##..#\n....##..##.\n...#..##..#\n\n.##.##..#\n....#.##.\n.##.#.##.\n.....####\n#..###..#\n....#.##.\n.##.#.##.\n.#...#..#\n.....#..#\n####.#..#\n.##.##..#\n#..#.....\n#..##.##.\n.##...##.\n######..#\n####.####\n.##...##.\n\n#####.##...#.\n..#......##..\n.###.#.#.##..\n####...#.##.#\n#...#....#...\n..###.#######\n#.####..###.#\n#.####..###.#\n..###.#######\n#...#....#...\n####...#.##.#\n.###.#.#.##..\n..#......##..\n#####..#...#.\n#####..#...#.\n\n..#.###.##..#\n######.#.#.#.\n######.#.#.#.\n..#.###.##..#\n#...#..###.#.\n############.\n..##.####...#\n#####.###....\n#...#####....\n##..#......#.\n##..#......#.\n#...#####....\n#####.###....\n..##.####...#\n############.\n#...#..###.##\n..#.###.##..#\n\n#.#..####\n.##.#####\n##.#.#...\n##.#.#...\n.##.#####\n#....####\n##..#.#..\n\n#####.#..\n#.#.#####\n..##.##..\n.....#.##\n..#####.#\n..#####.#\n.....#.##\n\n#..##.##.\n###.#.###\n#..####.#\n.##...#.#\n....##...\n....#.##.\n#..##..##\n....####.\n.##...#.#\n.##...#.#\n....####.\n#..##..##\n....#.##.\n\n##..####..##..##.\n.#..#..#...#..#..\n##..##...##.##.##\n##..###.#..####..\n.#..#......#..#..\n.......#.##.##.##\n.......###......#\n#######.###.##.##\n#....##.##......#\n##..###.#........\n##..###..#.####.#\n.#..#.#.#.......#\n##..#####..#..#..\n......##.########\n..##....#.######.\n\n.......#.#.#..#..\n.####.#.##.#..#..\n######.#####.#.##\n######.#####.#.##\n.####.#.##.#..#..\n.......#.#.#..#.#\n##..##..#.#..##..\n#.##.#.#..#..#.##\n.#..#.##..###...#\n\n#.#......\n...##..##\n.##.####.\n#..#....#\n#..#....#\n.##.####.\n#..##..##\n\n.#..#..\n#....##\n#....##\n.#..#..\n..##...\n..##..#\n#.##.##\n#....#.\n##..##.\n#....#.\n##...##\n\n##.###...\n..#.#...#\n####.###.\n##.#.##.#\n..#...#.#\n####..#..\n.......##\n...#.#...\n####.#...\n...#.#..#\n..#..#...\n....#.#.#\n..###..##\n..##.....\n..##.....\n..###..#.\n....#.#.#\n\n##.#.#.#.###...#.\n.##.#...#.###.#..\n###.######..#....\n###.######..#....\n.##.#...#.###.#..\n##.#.#.#.###...#.\n.##.#####.##..#..\n..##..###.#..#.##\n###..####.##.#..#\n###..####.##.#..#\n..##..###.##.#.##\n\n#....#.##\n#....#.#.\n.#..#.###\n..##..#.#\n#....##.#\n#.##.#...\n#.##.#..#\n.......#.\n##..####.\n\n##.#..#.##.....\n..........##.#.\n.#.#..#.#.##...\n###....########\n.########.###.#\n.##....##.#....\n#.#....#.#.#.##\n#.#....#.#.#.##\n.##....##......\n\n#.#.#.#..#.\n..##.......\n....##.##.#\n##...######\n#####.####.\n###..##..##\n.....######\n\n.....##......\n##..####.####\n..#..##..#...\n..#.####.#...\n#..#....#..##\n##...##...###\n.#..####..#..\n#.#......#.##\n.#.#.##.#.#..\n..##....##...\n##.##..##.###\n\n########.\n......###\n.####.##.\n.#..#.##.\n....#.###\n#######..\n......###\n##..##.##\n.#..#.#..\n.#..#.#..\n##..##.##\n\n##.#......#.##.\n###........####\n###..#..#..####\n.###..##..###.#\n.#.###..###...#\n.....####.....#\n#.###.##.###.##\n#............#.\n..###.##.###..#\n##.#.#..#.#.###\n...#..##..#....\n##.#.####.#.##.\n###.#.##.#.###.\n....######.....\n####......#####\n####......#####\n....######.....\n\n.....######..##\n######.....##..\n..###.##..####.\n.#..###.###..##\n#..###..#######\n.##..##.#.#..#.\n.##.###.#.#..#.\n\n#..#..#\n######.\n.....#.\n#..####\n.##....\n....###\n#..##.#\n#..###.\n####.#.\n.##.#.#\n#..#.#.\n....###\n.###.#.\n.##..#.\n.##..#."

def parse(line: String): (String, List[Int]) =
  val (s"$input $mask") = line: @unchecked
  (input, mask.split(',').map(_.toInt).toList)

def mostFrequentElement(list: List[Int]) : Int =
  list.groupBy(identity).maxBy(_._2.size)._1

//def scanCol(colIdx: Int, patternWidth: Int, ) : Int =
//  if colIdx < patternWidth then
//    scanCol(colIdx+1, patternWidth)
//  else
//    0

def findReflection(pattern:String, direction: String, originalPatternScore: (String, Int)): Int =
  // reflection must be to the edge
  // find potential reflection points using first line
  val rows = pattern.linesIterator.toList
  val patternWidth = rows(0).length
  //  println("pattern width: " + patternWidth)


  // only return the  first reflection found as there may be more after smudging
  var reflectionFound = false

  var reflectionPoints = mutable.Queue[Int]()
  for (rowIdx <- 0 until rows.length)
    val midPoint = Math.ceil(patternWidth.toDouble/2).toInt
    //      println(f"\nscanning row $rowIdx")
    //    println("mid point: " + midPoint)

    for (colIdx <- 1 until patternWidth)
    //      println(f"\nscanning col $colIdx")

      if (colIdx < midPoint) then
        val endIdx = colIdx + colIdx
        val leftHalf = rows(rowIdx).substring(0, colIdx)
        val rightHalf = rows(rowIdx).substring(colIdx, endIdx)

        //        println(f"left scan colIdx $colIdx / midPoint $midPoint / leftHalf $leftHalf / rightHalf $rightHalf")

        if (leftHalf == rightHalf.reverse) then
        //          println("reflection found")
          reflectionPoints.enqueue(colIdx)
      //        else
      //          reflectionPoint = 0 // i.e. not found

      else
        val startIdx = colIdx - (patternWidth - colIdx)
        val leftHalf = rows(rowIdx).substring(startIdx, colIdx)
        val rightHalf = rows(rowIdx).substring(colIdx)

        //        println(f"right scan colIdx $colIdx / midPoint $midPoint / leftHalf $leftHalf / rightHalf $rightHalf")

        if (leftHalf == rightHalf.reverse) then
        //          println("reflection found")
          reflectionPoints.enqueue(colIdx)
  //        else
  //          reflectionPoint = 0 // i.e. not found




//  println("reflectionPoints: " + reflectionPoints.toList )
  val filteredReflectionPoints = if direction == originalPatternScore._1 then
    reflectionPoints.filter(_ != originalPatternScore._2)
  else
    reflectionPoints

  println(s"filtered $direction reflectionPoints: " + filteredReflectionPoints.toList )

  val mostFrequent = mostFrequentElement(filteredReflectionPoints.toList)
  println(f"most frequent reflection point $mostFrequent for pattern dimension ${rows.size}")

  // make sure that the most frequent reflection index is same for every row
  if (filteredReflectionPoints.count(_ == mostFrequent) == rows.size) then

    // filter the reflection points to remove the original
    println(f"Original reflection is $originalPatternScore comparing to $direction $mostFrequent")
    if direction == originalPatternScore._1 && mostFrequent == originalPatternScore._2 then
      println("SKIPPING ORIGINAL REFLECTION")
      0
    else
      println(f"REFLECTION FOUND $direction $mostFrequent")
      println(pattern)
      println()
      mostFrequent
  else
    println("REFLECTION NOT FOUND")
    0

def findReflectionForOriginal(pattern:String, direction: String): Int =
  // reflection must be to the edge
  // find potential reflection points using first line
  val rows = pattern.linesIterator.toList
  val patternWidth = rows(0).length
//  println("pattern width: " + patternWidth)

  var reflectionPoints = mutable.Queue[Int]()
  for (rowIdx <- 0 until rows.length)
    val midPoint = Math.ceil(patternWidth.toDouble/2).toInt
//      println(f"\nscanning row $rowIdx")
//    println("mid point: " + midPoint)

    for (colIdx <- 1 until patternWidth)
//      println(f"\nscanning col $colIdx")

      if (colIdx < midPoint) then
        val endIdx = colIdx + colIdx
        val leftHalf = rows(rowIdx).substring(0, colIdx)
        val rightHalf = rows(rowIdx).substring(colIdx, endIdx)

//        println(f"left scan colIdx $colIdx / midPoint $midPoint / leftHalf $leftHalf / rightHalf $rightHalf")

        if (leftHalf == rightHalf.reverse) then
//          println("reflection found")
          reflectionPoints.enqueue(colIdx)
//        else
//          reflectionPoint = 0 // i.e. not found

      else
        val startIdx = colIdx - (patternWidth - colIdx)
        val leftHalf = rows(rowIdx).substring(startIdx, colIdx)
        val rightHalf = rows(rowIdx).substring(colIdx)

//        println(f"right scan colIdx $colIdx / midPoint $midPoint / leftHalf $leftHalf / rightHalf $rightHalf")

        if (leftHalf == rightHalf.reverse) then
//          println("reflection found")
          reflectionPoints.enqueue(colIdx)
//        else
//          reflectionPoint = 0 // i.e. not found

//  println("reflectionPoints: " + reflectionPoints.toList )


  val mostFrequent = mostFrequentElement(reflectionPoints.toList)
//  println("mostFrequent: " + mostFrequent + " with count " + reflectionPoints.count(_ == mostFrequent) + " and needs to match " + rows.size)

  // make sure that the most frequent reflection index is same for every row
  if(reflectionPoints.count(_ == mostFrequent) == rows.size) then
//    println(f"REFLECTION FOUND $direction $mostFrequent")
//    println(pattern)
//    println()
    mostFrequent
  else
//    println("REFLECTION NOT FOUND")
    0

def applySmudge(pattern: String) : List[String] =
  val rows = pattern.linesIterator.toList.size
  val cols = pattern.linesIterator.toList.head.length

  // for each square, clone the pattern and change char at index
  (0 until pattern.length).map( i =>

    if pattern(i) != '\n' then
      if pattern(i) == '#' then
        pattern.toList.updated(i,'.').mkString("")
      else
        pattern.toList.updated(i,'#').mkString("")
    else
      ""
  ).toList.filter(_.nonEmpty)

//  val patterns = mutable.Queue()
//
//  for (rowIdx <- 0 until rows)
//    for (colIdx <- 0 until cols)
//      pattern

//  List(pattern)

def getScoreForOriginalPattern(pattern: String): (String, Int) =
  val verticalReflectionIdx = findReflectionForOriginal(pattern,"VERTICAL")

  // then try horizontal scan
  val transposedPatten = pattern.linesIterator.toList.transpose.map(_.mkString(""))
  //  println(transposedPatten.mkString("\n"))
  val horizontalReflectionIdx = findReflectionForOriginal(transposedPatten.mkString("\n"), "HORIZONTAL")

  val score = verticalReflectionIdx + (horizontalReflectionIdx * 100)

  if verticalReflectionIdx > 0 then
    ("VERTICAL", verticalReflectionIdx)
  else
    ("HORIZONTAL", horizontalReflectionIdx)


def getScoreForPattern(pattern: String, originalPatternScore: (String, Int)): Int =
  println(pattern)
  val verticalReflectionIdx = findReflection(pattern,"VERTICAL", originalPatternScore)

  if verticalReflectionIdx > 0 then
    println(f"FOUND VERTICAL SO RETURNING score $verticalReflectionIdx, skipping horizontal scan")
    verticalReflectionIdx
  else
    // then try horizontal scan
    val transposedPatten = pattern.linesIterator.toList.transpose.map(_.mkString(""))
    println("TRYING TRANSPOSED")
    println(transposedPatten.mkString("\n"))
    val horizontalReflectionIdx = findReflection(transposedPatten.mkString("\n"), "HORIZONTAL", originalPatternScore)

    println(f"horizontalReflectionIdx $horizontalReflectionIdx")
    if horizontalReflectionIdx > 0 then
      val score = horizontalReflectionIdx * 100
      println(f"FOUND HORIZONTAL SO RETURNING score $score")
      score
    else
      println(f"NO REFLECTION FOUND AT ALL")
      0


def solution(input: String): Int =
  val scores = input.split("\n\n").zipWithIndex.map { case (pattern, idx) =>
    println(f"Pattern ${idx+1}")

    val originalPatternScore = getScoreForOriginalPattern(pattern)

    val smudgedPatterns = applySmudge(pattern)
//    println(s"Generated ${smudgedPatterns.size} smudges")

    var found = false
    var score = 0
    for (i <- smudgedPatterns.indices)
      println("\nSMUDGE " + (i+1) + " " + found)
      if !found then
        score = getScoreForPattern(smudgedPatterns(i), originalPatternScore)
        println(f"score for smudge ${i+1} is $score")
        if score > 0 then
          println(f"setting found to true, do not update score any further for this pattern")
          found = true

    score
  }.toList

  println("Scores: " + scores.mkString("Array(", ", ", ")"))
  println(f"Total score: ${scores.sum}")
  scores.sum




var startTime = System.currentTimeMillis()
solution(sampleInput)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Time taken: $timeTaken ms")

startTime = System.currentTimeMillis()
solution(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Time taken: $timeTaken ms")
//27860 too low


//"123##32131".zipWithIndex.filter(pair => pair._1 == "##").map(pair => pair._2).toList

val string = "1##23##32131"
val re = "##".r
re.findAllIn(string).toList
string.zipWithIndex

(1 until 9).foreach(println)

"123456789".substring(0,1)
"123456789".substring(1,2)

List(1,1,1,3).groupBy(identity).maxBy(_._2.size)

def scanCol(colIdx: Int, patternWidth: Int ) : Int =
  if colIdx < patternWidth then
    scanCol(colIdx+1, patternWidth)
  else
    0

val s ="123\n456"
s.toList.updated(3,'.')
println(s)

"123\n456"(3) == '\n'

applySmudge("###\n###")

