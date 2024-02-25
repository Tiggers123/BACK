import Link from "next/link";
import styles from "./menu.module.css";

const Menu = () => {
  return (
    <div className={styles.menuContainer}>
      <h1 className={styles.title}>UPBEAT</h1>
      <div className={styles.buttonGroup}>
        <Link href="/pages/Game">
          <button class={styles.button}>
            <span class={styles.buttontext}>Start</span>
            <div class={styles.fillcontainer}></div>
          </button>
        </Link>
        <Link href="/pages/Howto">
          <button class={styles.button}>
            <span class={styles.buttontext}>How to play</span>
            <div class={styles.fillcontainer}></div>
          </button>
        </Link>
        <Link href="/pages/Configuration">
          <button class={styles.button}>
            <span class={styles.buttontext}>Setting Config</span>
            <div class={styles.fillcontainer}></div>
          </button>
        </Link>
        <Link href="/">
          <button class={styles.button}>
            <span class={styles.buttontext}>Back to Menu :)</span>
            <div class={styles.fillcontainer}></div>
          </button>
        </Link>
        <div className={styles.imageContainer}></div>
        <div className={styles.imagesContainer}></div>
      </div>
    </div>
  );
};

export default Menu;
