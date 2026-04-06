## 代码管理
### 分支说明
- main分支：公共代码库，用于ent-dev分支和per-dev分支之间共享、同步、合并代码。例如ent-dev分支提交的公共功能组件，或者命名以及代码完全相同的业务功能文件，per-dev分支合并后，稍作适配修改即可使用
- ent-dev = 企业版代码分支。基础功能和个人版代码相同，但是支持后端server，属于CS架构。
- per-dev = 个人版代码分支。基础功能和企业版代码相同，但是只支持局域网通信，无后端server。

### 开发说明
两个版本开发过程中，要尽量考虑抽取公共代码，提交到main分支，方便另外一个版本使用，减少开发的工作量，最大程度保持两个版本主体功能和界面效果相同。

### 合并代码说明
企业版分支和个人版分支，有公共组件代码需要往main分支提交的时候，不允许直接提交合并，需要用 git cherry-pick 或 patch 方式合入 main

---

## 🔧 开发环境

### 必需环境

| 环境          | 版本要求                     | 说明              |
|-------------|--------------------------|-----------------|
| **Node.js** | `^20.19.0` 或 `>=22.12.0` | JavaScript 运行环境 |
| **pnpm**    | `>=10.x`                 | 包管理器，必须使用 pnpm  |
| **Rust**    | `最新稳定版`                  | Tauri 后端开发需要    |
| **Git**     | `2.0+`                   | 版本控制            |
| **Java**    | `OpenJDK 21`             | Java运行环境        |

### 操作系统支持

| 平台 | 支持版本 |
|------|---------|
| **Windows** | Windows 10, Windows 11 |
| **macOS** | macOS 10.15+ |
| **Linux** | Ubuntu 20.04+ |
| **iOS/iPadOS** | iOS 13.0+, iPadOS 13.0+ |
| **Android** | Android 8.0+ (API 26+) |

---

## 🐛 如何提交代码

### 开发和测试
```bash
   # 安装依赖
   pnpm i

   # 启动开发环境
   pnpm run td

   # 运行代码检查
   pnpm run lint:staged

   # 运行测试
   pnpm run test:run
   ```

### 代码提交规范

项目使用 [Conventional Commits](https://www.conventionalcommits.org/) 规范：

| 类型 | 说明 | 示例 |
|------|------|------|
| `feat` | 新功能 | `feat: 添加消息撤回功能` |
| `fix` | 修复 Bug | `fix: 修复登录页面样式问题` |
| `docs` | 文档更新 | `docs: 更新 API 文档` |
| `style` | 代码格式化 | `style: 格式化组件代码` |
| `refactor` | 重构代码 | `refactor: 优化消息发送逻辑` |
| `perf` | 性能优化 | `perf: 优化图片加载性能` |
| `test` | 添加测试 | `test: 添加登录功能单元测试` |
| `chore` | 构建过程或辅助工具变动 | `chore: 更新依赖版本` |
