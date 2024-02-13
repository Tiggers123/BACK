import Image from "next/image";
import Link from "next/link";
import styles from "./home.module.css";

const Home = () => {
  return (
    <header className="bg-black h-dvh text-7xl flex flex-col justify-center text-center items-center">
      <div className="text-9xl mb-10 text-white">
        <div className={styles.imgContainer}>
           <Image src="/5.gif" alt="" fill className={styles.heroImg} />
          {" "}
        </div>
        <p>UPBEAT</p>
      </div>
      <div>
        <div className="styles.button">
          <Link href="/pages/join">Play</Link>
        </div>
        <div>
          <Link href="/pages/how-to-play" className="styles.button">
            How to Play
          </Link>
        </div>
      </div>
    </header>
  );
};
export default Home;

// import Image from "next/image";
// import styles from "./home.module.css";

// const Home = () => {
//   return (
//     <div className={styles.container}>
//       <div className={styles.textContainer}>
//         <h1 className={styles.title}>Creative Thoughts Agency.</h1>
//         <p className={styles.desc}>
//           Lorem, ipsum dolor sit amet consectetur adipisicing elit. Vero
//           blanditiis adipisci minima reiciendis a autem assumenda dolore.
//         </p>
//         <div className={styles.buttons}>
//           <button className={styles.button}>Learn More</button>
//           <button className={styles.button}>Contact</button>
//         </div>
//         <div className={styles.brands}>
//           <Image src="/1.gif" alt="" fill className={styles.brandImg} />
//         </div>
//       </div>
//       <div className={styles.imgContainer}>
//         <Image src="/1.gif" alt="" fill className={styles.heroImg} />
//       </div>
//     </div>
//   );
// };

// export default Home;
